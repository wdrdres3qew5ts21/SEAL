package seal.SubjectService.Program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import seal.SubjectService.Subject.Subject;

@Service
public class ProgramAdapter {
    private static final String PREFIX = "https://ngelearning.sit.kmutt.ac.th/api/v0/program/";

    
    public List<Program> getAllProgramsDetail(){
        RestTemplate restTemplate = new RestTemplate();
        String url = PREFIX;
        List<Program> programs = restTemplate.getForObject(url, List.class);
        return programs;
    }

    public List<Subject> getAllSubjectsByProgramId(String programId){
        RestTemplate restTemPlate = new RestTemplate();
        String url = PREFIX + programId + "/subjects";
        List<Subject> subjects = restTemPlate.getForObject(url, List.class);
        return subjects;
    }

    public List<Subject> findSubjects(String programId, String findText) {
        findText = findText.toLowerCase();
        List<Subject> allSubjects = getAllSubjectsByProgramId(programId);
        List<Subject> findSubjects = new ArrayList();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < allSubjects.size(); i++) {
            Subject subject = mapper.convertValue(allSubjects.get(i), Subject.class);
            String codeLower = subject.getCode().toLowerCase();
            String nameLower = subject.getName().toLowerCase();
            if (findText(codeLower, findText) || findText(nameLower, findText)) {
                findSubjects.add(subject);
            }
        }
        return findSubjects;
    }

    private boolean findText(String text, String find) {
        int index = text.indexOf(find);
        return index >= 0;
    }

    // private <T> List<T> jsonArrayToObjectList(String json, Class<T> tClass) throws IOException {
    //     ObjectMapper mapper = new ObjectMapper();
    //     CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
    //     List<T> ts = mapper.readValue(json, listType);
    //     return ts;
    // }
}