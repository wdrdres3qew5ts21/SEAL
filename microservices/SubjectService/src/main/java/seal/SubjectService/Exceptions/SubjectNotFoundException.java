/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seal.SubjectService.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import seal.SubjectService.Logger.JSONLogger;

/**
 *
 * @author wdrdr
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubjectNotFoundException extends RuntimeException {

    private JSONLogger jsonLogger;

    public SubjectNotFoundException(String subject_id) {
        super("Subject '" + subject_id + "' is Not Found!!");
        jsonLogger.ErrorJSONLogger("Subject '" + subject_id + "' is Not Found!!");;
    }


}
