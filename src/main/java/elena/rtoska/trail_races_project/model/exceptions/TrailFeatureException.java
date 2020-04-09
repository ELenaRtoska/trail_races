package elena.rtoska.trail_races_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TrailFeatureException extends RuntimeException {

    public TrailFeatureException() {
        super("There can be max 3 trail features in the race!");
    }
}
