/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.FileService.controller;

import io.jsonwebtoken.Claims;
import seal.FileService.service.FileService;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import seal.FileService.Filter.TokenAuthenticationService;
import seal.FileService.model.SubjectFile;
import seal.FileService.service.FileService;

/**
 *
 * @author wdrdr
 */
@CrossOrigin(origins = "*")
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<SubjectFile> uploadFile(@RequestPart(value = "file") MultipartFile file, @RequestParam(value = "subjectId") int subjectId, HttpServletRequest request) {
        Claims user = TokenAuthenticationService.validateJWTAuthentication(request);
        TokenAuthenticationService.validateIsUserRoleTeacher(user);
        return new ResponseEntity<SubjectFile>(this.fileService.uploadFile(file, subjectId), HttpStatus.CREATED);
    }

    @GetMapping("/files")
    public ResponseEntity<List<SubjectFile>> getAllFiles(HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        return new ResponseEntity<List<SubjectFile>>(fileService.findAllFiles(), HttpStatus.OK);
    }

    @GetMapping("/files/{fileId}")
    public ResponseEntity<SubjectFile> getFilesById(@PathVariable int fileId, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        return new ResponseEntity<SubjectFile>(fileService.findById(fileId), HttpStatus.OK);
    }

    @GetMapping("/files/subject/{subjectId}")
    public ResponseEntity<List<SubjectFile>> getFilesBySubjectId(@PathVariable int subjectId, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        return new ResponseEntity<List<SubjectFile>>(fileService.findBySubjectId(subjectId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{fileId}")
    public SubjectFile deleteFile(@PathVariable String fileId, HttpServletRequest request) {
        Claims user = TokenAuthenticationService.validateJWTAuthentication(request);
        TokenAuthenticationService.validateIsUserRoleTeacher(user);
        return this.fileService.deleteFileFromS3Bucket(fileId);
    }

}
