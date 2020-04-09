package elena.rtoska.trail_races_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TrailRaceException extends RuntimeException {

    public TrailRaceException() {
        super("Not all features are trail!");
    }
}
