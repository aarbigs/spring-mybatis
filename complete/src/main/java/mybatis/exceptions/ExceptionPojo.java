package mybatis.exceptions;

/**
 * Created by aaron on 8/9/17.
 */
public class ExceptionPojo {

    String message;
    int errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
