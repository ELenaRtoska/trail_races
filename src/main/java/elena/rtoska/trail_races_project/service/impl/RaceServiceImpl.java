package elena.rtoska.trail_races_project.service.impl;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import elena.rtoska.trail_races_project.model.exceptions.InvalidFeatureIdException;
import elena.rtoska.trail_races_project.model.exceptions.InvalidPageException;
import elena.rtoska.trail_races_project.model.exceptions.InvalidRaceIdException;
import elena.rtoska.trail_races_project.model.exceptions.TrailRaceException;
import elena.rtoska.trail_races_project.repository.FeatureRepository;
import elena.rtoska.trail_races_project.repository.RaceRepository;
import elena.rtoska.trail_races_project.service.RaceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final FeatureRepository featureRepository;

    public RaceServiceImpl(RaceRepository raceRepository, FeatureRepository featureRepository) {
        this.raceRepository = raceRepository;
        this.featureRepository = featureRepository;
    }

    @Override
    public elena.rtoska.trail_races_project.model.vm.Page<Race> getAll(int page, int size) {
//        if(size > 10)
//            throw new InvalidPageException();
        Page<Race> repoPage = this.raceRepository.findAll(PageRequest.of(page, size, Sort.by("type")));
        return new elena.rtoska.trail_races_project.model.vm.Page<>(page, repoPage.getTotalPages(), size, repoPage.getContent());
    }

    @Override
    public List<Race> getAll() {
        return this.raceRepository.findAll();
    }

    @Override
    public Race create(String raceType, String description){
        return this.raceRepository.save(new Race(raceType, description));
    }

    @Override
    public Race create(String raceType, String description, boolean trailRace, List<UUID> featuresIds) {
        List<Feature> features = this.featureRepository.findAllById(featuresIds);
        if(trailRace)
            this.allTrailRacesFeaturesCheck(features);
        return this.raceRepository.save(new Race(raceType, description, features,trailRace));
    }

    private void allTrailRacesFeaturesCheck(List<Feature> features){
        if(!features.stream().allMatch(Feature::isTrailRace))
            throw new TrailRaceException();
    }

    @Override
    public List<Race> getAllContainingFeature(UUID featureId) {
        Feature feature = this.featureRepository.findById(featureId).orElseThrow(InvalidFeatureIdException::new);
        return this.raceRepository.findAllByFeaturesContaining(feature);
    }

    @Override
    public Race putUpdate(UUID id, String raceType, String description, boolean trailRace, List<UUID> featuresIds) {
        Race toEdit = this.raceRepository.findById(id).orElseThrow(InvalidRaceIdException::new);
        List<Feature> features = this.featureRepository.findAllById(featuresIds);
        if(trailRace)
            this.allTrailRacesFeaturesCheck(features);
        toEdit.setType(raceType);
        toEdit.setDescription(description);
        toEdit.setTrailRace(trailRace);
        toEdit.setFeatures(features);
        return this.raceRepository.save(toEdit);
    }

    @Override
    public void delete(UUID id) {
        this.raceRepository.deleteById(id);
    }

    @Override
    public Race getById(UUID id) {
        return this.raceRepository.findById(id).orElseThrow(InvalidRaceIdException::new);
    }

    @Override
    public List<Race> getAllWithFeaturesCountLessThan(int totalFeatures) {
        return this.raceRepository.findAllWithFeaturesLessThan(totalFeatures);
    }

    @Override
    public List<Race> getAllWithTrailFeature() {
        return this.raceRepository.findDistinctByFeatures_TrailIsTrue();
    }




}
