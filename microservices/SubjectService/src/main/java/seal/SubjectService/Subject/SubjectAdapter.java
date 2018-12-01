/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.SubjectService.Subject;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import seal.SubjectService.Exceptions.NotFoundException;
import seal.SubjectService.Exceptions.SubjectNotFoundException;
import seal.SubjectService.Program.Program;

/**
 *
 * @author wdrdr
 */
@Service
public class SubjectAdapter {
    private static final String SUBJECT_PREFIX="https://ngelearning.sit.kmutt.ac.th/api/v0/subject/";
    
     public Subject findSubjectById(int subjectId){
        RestTemplate restTemplate = new RestTemplate();
        String subjectURL = SUBJECT_PREFIX + subjectId;
        Subject subject = restTemplate.getForObject(subjectURL, Subject.class);
        if(subject == null){
            throw new SubjectNotFoundException(subjectURL);
        }
        return subject;
    }
    
}
