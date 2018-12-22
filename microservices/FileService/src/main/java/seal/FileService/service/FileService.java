/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.FileService.service;

/**
 *
 * @author wdrdr
 */
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import seal.FileService.model.SubjectFile;
import seal.FileService.repository.SubjectFileRepository;

@Service
public class FileService {

    private AmazonS3 s3client;

    @Autowired
    private SubjectFileRepository subjectFileRepository;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    public SubjectFile uploadFile(MultipartFile multipartFile, String subjectId) {
        String fileUrl = "";
        String fileName="";
        try {
            File file = convertMultiPartToFile(multipartFile);
            fileName = generateFileName(multipartFile);
            fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
            this.uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SubjectFile subjectFile = new SubjectFile();
        subjectFile.setFileUrl(fileUrl);
        subjectFile.setSubjectId(subjectId);
        subjectFile.setFileName(fileName);
        System.out.println(subjectFile);
        return subjectFileRepository.save(subjectFile);
    }

    public SubjectFile deleteFileFromS3Bucket(String fileId) {
        try {
            SubjectFile deletedFile = subjectFileRepository.findById(Integer.parseInt(fileId)).get();
            String fileUrl = deletedFile.getFileUrl();
            System.out.println("Deleted : " + deletedFile);
            String fileName = deletedFile.getFileUrl().substring(fileUrl.lastIndexOf("/") + 1);
            System.out.println(fileName);
            fileName = URLDecoder.decode(fileName, "UTF-8");
            System.out.println("File Name : " + fileName);
            s3client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
            subjectFileRepository.delete(deletedFile);
            return deletedFile;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public SubjectFile findById(int fileId) {
        return subjectFileRepository.getOne(fileId);
    }

    public List<SubjectFile> findAllFiles() {
        return subjectFileRepository.findAll();
    }

    public List<SubjectFile> findBySubjectId(String subjectId) {
        return subjectFileRepository.findBySubjectId(subjectId);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @PostConstruct
    private void initializeAmazon() {
        System.out.println("Endpoint : " + endpointUrl);
        System.out.println("Bucketname : " + bucketName);
        System.out.println("AccessKey : " + accessKey);
        System.out.println("Secret Key : " + secretKey);
        System.out.println("---------------------------------------------------------------");
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.s3client = new AmazonS3Client(credentials);
        // ObjectListing listObjects = this.s3client.listObjects(bucketName, "L"); หาไฟล์ตาม Keyword
        ObjectListing listObjects = this.s3client.listObjects(bucketName);
        for (S3ObjectSummary objectSummary : listObjects.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  "
                    + "(size = " + objectSummary.getSize() + ") "
            );
        }
    }

}
