package seal.SubjectService.Program;

import java.io.UnsupportedEncodingException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import seal.SubjectService.Exceptions.BadRequestException;
import seal.SubjectService.Exceptions.NotFoundException;
import seal.SubjectService.Subject.Subject;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import seal.SubjectService.Filter.TokenAuthenticationService;
import seal.SubjectService.Subject.SubjectAdapter;

@CrossOrigin(origins = "*")
@RestController
public class ProgramController {

    @Autowired
    private ProgramAdapter programAdapter;


    @Autowired
    private BadRequestException badRequestException;

    @GetMapping("/programs")
    public ResponseEntity<List<Program>> getPrograms(HttpServletRequest request) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        System.out.println("programs controller : "+request.getHeader("Authorization"));
        List<Program> programs = programAdapter.getAllProgramsDetail();
        System.out.println(programs.toString());
        return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
    }
    

    @RequestMapping(
            value = "/program/{program_id}/subjects",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Subject>> findSubjects(
            @PathVariable("program_id") String program_id,
            @RequestParam(name = "find", required = false) String find,
            HttpServletRequest request
    ) {
        TokenAuthenticationService.validateJWTAuthentication(request);
        List<Subject> subjects = null;
        if (find == null) {
            try {
                subjects = programAdapter.getAllSubjectsByProgramId(program_id);
            } catch (HttpClientErrorException error) {
                throw new NotFoundException(program_id);
            }
        } else {
            if (find.length() == 0) {
                throw new BadRequestException(badRequestException.getINCORRECT_PARAM());
            }
            try {
                subjects = programAdapter.findSubjects(program_id, find);
            } catch (HttpClientErrorException error) {
                throw new NotFoundException(program_id, find);
            }
        }
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
}
