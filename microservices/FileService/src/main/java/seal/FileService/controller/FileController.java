/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.FileService.controller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import seal.FileService.model.SubjectFile;
import seal.FileService.service.AmazonClient;

/**
 *
 * @author wdrdr
 */
@CrossOrigin(origins = "*")
@RestController
public class FileController {

    @Autowired
    private AmazonClient amazonClient;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return new ResponseEntity<String>(this.amazonClient.uploadFile(file), HttpStatus.CREATED);
    }
    
    @GetMapping("/files")
    public ResponseEntity<List<SubjectFile>> getAllFiles(){
      //  return new ResponseEntity<>(amazonClient);
      return null;
    }
    
    @DeleteMapping("/delete")
    public String deleteFile(@RequestBody HashMap<String, String> deletedFile) {
        String fileUrl = deletedFile.get("fileUrl");
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }
    
}
