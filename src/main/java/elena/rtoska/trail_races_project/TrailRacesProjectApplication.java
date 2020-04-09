package elena.rtoska.trail_races_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TrailRacesProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrailRacesProjectApplication.class, args);
    }

}


