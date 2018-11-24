package seal.VideoService.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
  private static final Logger logger = LoggerFactory.getLogger(NotFoundException.class);

  public NotFoundException (String progrma_id) {
    super("'"+progrma_id+"' Not Found!!");
  }
}
