package seal.SubjectService.Nge.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    
    @Autowired
    private SubjectAdepter subjectAdepter;

    @RequestMapping(value="/subjects", method=RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjects(){
        List<Subject> subjects = subjectAdepter.getAllSubjectsDetail();
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
}