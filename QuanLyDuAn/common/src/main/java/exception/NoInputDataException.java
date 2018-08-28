package exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No input data exception")
public class NoInputDataException extends RuntimeException{
    public NoInputDataException(String msg){super(msg);}

}
