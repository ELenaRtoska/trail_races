package elena.rtoska.trail_races_project.web.rest;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import elena.rtoska.trail_races_project.model.vm.Page;
import elena.rtoska.trail_races_project.service.FeaturesService;
import elena.rtoska.trail_races_project.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/races", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:3000")
public class RacesApi {

    private final RaceService raceService;
    private final FeaturesService featuresService;

    public RacesApi(RaceService raceService, FeaturesService featuresService) {
        this.raceService = raceService;
        this.featuresService = featuresService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Race createRace(@RequestParam String type,
                           @RequestParam String description,
                           @RequestParam Optional<Boolean> trailRace,
                           @RequestParam List<UUID> features,
                           HttpServletResponse response,
                           UriComponentsBuilder builder){
        Race result = this.raceService.create(type, description, trailRace.orElse(false), features);
        response.setHeader("Location", builder.path("/api/races/{raceId}").buildAndExpand(result.getId()).toUriString());
        return result;
    }

    @PatchMapping(path = "/{id}")
    public Race updateRace(@PathVariable UUID id,
                           @RequestParam String type,
                           @RequestParam String description,
                           @RequestParam Optional<Boolean> trailRace,
                           @RequestParam List<UUID> features){
        return this.raceService.putUpdate(id, type, description, trailRace.orElse(false), features);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteRace(@PathVariable UUID id){
        this.raceService.delete(id);
    }

    @GetMapping
    public Page<Race> getAllFeatures(@RequestParam(required = false, defaultValue = "0") int page,
                                        @RequestParam(required = false, defaultValue = "5") int size,
                                        @RequestParam(required = false, defaultValue = "false") boolean trail){

        return this.raceService.getAll(page, size);
    }

    @GetMapping(path = "/{id}")
    public Race getRace(@PathVariable UUID id){
        return this.raceService.getById(id);
    }

    @GetMapping(path = "/compare")
    public List<Feature> compareRaces(@RequestParam UUID race1, @RequestParam UUID race2){
        return this.featuresService.getCommonFeaturesBetween(race1, race2);
    }

    @GetMapping(path = "/trail")
    public List<Race> getRacesWithTrailFeature(){
        return this.raceService.getAllWithTrailFeature();
    }

    @GetMapping("/all")
    public List<Race> getAll(){
        return this.raceService.getAll();
    }



}



