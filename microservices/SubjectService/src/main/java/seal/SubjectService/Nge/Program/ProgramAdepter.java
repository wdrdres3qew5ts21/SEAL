package seal.SubjectService.Nge.Program;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import seal.SubjectService.Nge.Subject.Subject;

@Service
public class ProgramAdepter {
    private static final String PREFIX = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/";

    public List<Program> getAllProgramsDetail(){
        RestTemplate restTemplate = new RestTemplate();
        String url = PREFIX;
        List<Program> programs = restTemplate.getForObject(url, List.class);
        return programs;
    }

    public List<Program> getAllSubjectsByProgramId(String programId){
        RestTemplate restTemPlate = new RestTemplate();
        String url = PREFIX + programId + "/subjects";
        List<Program> subjects = restTemPlate.getForObject(url, List.class);
        return subjects;
    }
}