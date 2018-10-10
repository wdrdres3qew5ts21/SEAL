package seal.SubjectService.Nge.Program;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProgramAdepter {

    public List<Program> getAllProgramsDetail(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/";
        List<Program> programs = restTemplate.getForObject(url, List.class);
        return programs;
    }
}