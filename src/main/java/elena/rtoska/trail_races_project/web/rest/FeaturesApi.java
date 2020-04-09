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
@RequestMapping(path = "/api/features", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:3000")
public class FeaturesApi {

    private final FeaturesService featuresService;
    private final RaceService raceService;

    public FeaturesApi(FeaturesService featuresService, RaceService raceService) {
        this.featuresService = featuresService;
        this.raceService = raceService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Feature createFeature(@RequestParam String name,
                                    @RequestParam boolean trail,
                                    @RequestParam float amount,
                                    @RequestParam boolean trailRace,
                                    HttpServletResponse response,
                                    UriComponentsBuilder builder){
        Feature result = this.featuresService.create(name, trail, amount, trailRace);
        response.setHeader("Location", builder.path("/api/features/{featureId}").buildAndExpand(result.getId()).toUriString());
        return result;
    }

    @PatchMapping(path = "/{id}")
    public Feature updateFeature(@PathVariable UUID id,
                                    @RequestParam Optional<String> name,
                                    @RequestParam Optional<Boolean> trail,
                                    @RequestParam Optional<Float> amount,
                                    @RequestParam Optional<Boolean> trailRace){
        return this.featuresService.patchUpdate(id, name, trail, amount, trailRace);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFeature(@PathVariable UUID id){
        this.featuresService.delete(id);
    }

    @GetMapping("/{id}")
    public Feature getFeature(@PathVariable UUID id){
        return this.featuresService.getById(id);
    }

    @GetMapping
    public Page<Feature> getAllFeatures(@RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "5") int size,
                                           @RequestParam(required = false, defaultValue = "false") boolean trail){

        if(trail)
            return this.featuresService.getTrail();
        return this.featuresService.getAll(page, size);
    }

    @GetMapping("/all")
    public List<Feature> getAll(){
        return this.featuresService.getAll();
    }

    @GetMapping(path = "/trailRace")
    public List<Feature> getTrailRaceFeatures(){
        return this.featuresService.getTrailRace();
    }

    @GetMapping("/{featureId}/races")
    public List<Race> getRacesWithFeature(@PathVariable UUID featureId){
        return this.raceService.getAllContainingFeature(featureId);
    }


}
