package seal.SubjectService.Nge.Subject;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubjectAdepter {

    public List<Subject> getAllSubjectsDetail(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/1/subjects";
        List<Subject> subjects = restTemplate.getForObject(url, List.class);
        return subjects;
    }
}