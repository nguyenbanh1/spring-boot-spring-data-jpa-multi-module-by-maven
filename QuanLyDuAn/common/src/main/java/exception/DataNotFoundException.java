package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Not found data")
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException (String msg){
        super(msg);
    }
}
