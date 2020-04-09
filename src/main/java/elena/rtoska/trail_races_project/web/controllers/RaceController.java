package elena.rtoska.trail_races_project.web.controllers;

import elena.rtoska.trail_races_project.service.RaceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @PostMapping(path = "/races/create")
    public String createRace(@RequestParam(value = "race") String raceName, @RequestParam String description){
        this.raceService.create(raceName, description);
        return "redirect:/";
    }

}
