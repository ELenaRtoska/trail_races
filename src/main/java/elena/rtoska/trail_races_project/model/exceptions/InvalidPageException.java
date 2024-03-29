package elena.rtoska.trail_races_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPageException extends RuntimeException {

    public InvalidPageException() {
        super(InvalidPageException.class.getSimpleName());
    }

}
