package mybatis.exceptions;

/**
 * Created by aaron on 8/9/17.
 */
public class APIException extends Exception {

    public String toString(){
        return "error connecting to darksky API";
    }
}
