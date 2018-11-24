package seal.SubjectService.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(NotFoundException.class);

  public NotFoundException(String program_id){
    super("Program '"+program_id+"' is Not Found!!");  
  }
  
  public NotFoundException(String program_id, String find) {
    super("Program '"+program_id+"' And Find Subject '"+find+"' Are Not Found!!");
  }
}
