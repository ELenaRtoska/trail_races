package elena.rtoska.trail_races_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvalidRaceIdException extends RuntimeException {

    public InvalidRaceIdException() {
        super("No such race!");
    }
}
