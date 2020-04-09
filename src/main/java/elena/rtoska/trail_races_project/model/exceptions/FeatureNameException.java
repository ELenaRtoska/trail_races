package elena.rtoska.trail_races_project.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FeatureNameException extends RuntimeException {

    public FeatureNameException(String name) {
        super("An feature with the name: " + name + " exists!");
    }
}
