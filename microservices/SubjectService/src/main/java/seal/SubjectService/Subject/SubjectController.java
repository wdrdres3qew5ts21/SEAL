/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.SubjectService.Subject;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import seal.SubjectService.Filter.TokenAuthenticationService;

/**
 *
 * @author wdrdr
 */
@CrossOrigin(origins = "*")
@RestController
public class SubjectController {

    @Autowired
    private SubjectAdapter subjectAdapter;

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable int subjectId, HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        Subject subject = subjectAdapter.findSubjectById(subjectId);
        return new ResponseEntity<Subject>(subject, HttpStatus.OK);
    }

}
