package mybatis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aaron on 8/9/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)  // 409
    @ExceptionHandler(APIException.class)
    public ExceptionPojo handleApiException() {
        ExceptionPojo exceptionPojo = new ExceptionPojo();
        exceptionPojo.setMessage("darksky API did not respond");
        exceptionPojo.setErrorCode(500);
        return exceptionPojo;
    }
}
