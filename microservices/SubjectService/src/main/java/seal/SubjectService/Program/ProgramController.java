package seal.SubjectService.Program;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import seal.SubjectService.Exceptions.BadRequestException;
import seal.SubjectService.Exceptions.NotFoundException;
import seal.SubjectService.Subject.Subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class ProgramController {
    @Autowired
    private ProgramAdepter programAdepter;

    @Autowired
    private BadRequestException badRequestException;

    @RequestMapping(value = "/programs", method = RequestMethod.GET)
    public ResponseEntity<List<Program>> getPrograms() {
        List<Program> programs = programAdepter.getAllProgramsDetail();
        return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/program/{program_id}/subjects",
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Subject>> findSubjects(
            @PathVariable("program_id") String program_id,
            @RequestParam(name = "find", required = false) String find
    ) {
        List<Subject> subjects = null;
        if (find == null) {
            try {
                subjects = programAdepter.getAllSubjectsByProgramId(program_id);
            } catch (HttpClientErrorException error) {
                throw new NotFoundException(program_id);
            }
        } else {
            if (find.length() == 0) {
                throw new BadRequestException(badRequestException.getINCORRECT_PARAM());

            }
            try {
                subjects = programAdepter.findSubjects(program_id, find);
            } catch (HttpClientErrorException error) {
                throw new NotFoundException(program_id, find);
            }
        }
        return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
    }
}
