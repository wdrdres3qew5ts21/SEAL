package seal.SubjectService;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import seal.SubjectService.Program.Program;
import seal.SubjectService.Program.ProgramAdapter;
import seal.SubjectService.Subject.Subject;

@RunWith(MockitoJUnitRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes=ProgramAdapter.class)
public class SubjectServiceApplicationTests {
        
    @Mock
	private ProgramAdapter programAdepter;

	private List<Subject> subjects;
	private List<Program> programs;

	@Before
	public void setUp(){
        this.programAdepter = new ProgramAdapter();
                
		subjects = new ArrayList<>();
		subjects.add(new Subject("44", "Web Programming", "INT303", ""));
                subjects.add(new Subject("55", "Computer Programming", "INT102", ""));
                subjects.add(new Subject("66", "Java Programming II", "INT105",""));

		programs = new ArrayList<>();
		programs.add(new Program("1", "Information Technology", "B.Sc.IT", ""));
		programs.add(new Program("2", "Computer science", "B.Sc.CS", ""));
	}

	@Test
	public void searchWithKeyword() throws Exception {
		List<Subject> subjectResponse = programAdepter.findSubjects("1", "pro");
                System.out.println("\nResult: "+programAdepter.findSubjects("1", "pro").toString()+"\n");
		assertThat(subjectResponse.get(0).getName().toLowerCase()).contains("pro");
	}

	@Test
	public void showAllProgram(){
		List<Program> programResponse = programAdepter.getAllProgramsDetail();
			
		System.out.println("\nResult: "+programAdepter.getAllProgramsDetail().toString()+"\n");
			
		assertThat(programResponse.size()==2);
	}
        
        
        
        

}
