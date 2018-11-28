package seal.SubjectService.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import seal.SubjectService.Logger.JSONLogger;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Component
public class BadRequestException extends RuntimeException {
  private JSONLogger jsonLogger; 

  private static final String INCORRECT_PARAM = "Incorrect Parameter";
  
  public BadRequestException() {
      super();
  }

  public BadRequestException (String message) {
    super(message);
    jsonLogger.ErrorJSONLogger(message);
  }


  public String getINCORRECT_PARAM() {
    return this.INCORRECT_PARAM;
  }



}
