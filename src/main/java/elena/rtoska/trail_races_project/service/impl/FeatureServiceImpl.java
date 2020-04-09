package elena.rtoska.trail_races_project.service.impl;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import elena.rtoska.trail_races_project.model.exceptions.*;
import elena.rtoska.trail_races_project.repository.FeatureRepository;
import elena.rtoska.trail_races_project.repository.RaceRepository;
import elena.rtoska.trail_races_project.service.FeaturesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeatureServiceImpl implements FeaturesService {

    private final FeatureRepository featureRepository;
    private final RaceRepository raceRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository, RaceRepository raceRepository) {
        this.featureRepository = featureRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public Feature create(String name, boolean trail, float amount, boolean trailRace) {
        this.createFeatureConstraintsCheck(name, trail);
        return this.featureRepository.save(new Feature(name, trail, amount, trailRace));
    }

    private void createFeatureConstraintsCheck(String name, boolean trail){
        if(this.featureRepository.existsByName(name))
            throw new FeatureNameException(name);
        if(trail && this.featureRepository.countAllByTrailIsTrue() == 3)
            throw new TrailFeatureException();
    }

    private void patchFeatureNameConstraintCheck(String oldName, String newName){
        if(!oldName.equals(newName) && this.featureRepository.existsByName(newName))
            throw new FeatureNameException(newName);
    }

    private void patchFeatureTrailConstraint(boolean wasTrail, boolean isTrail){
        if(!wasTrail && isTrail && this.featureRepository.countAllByTrailIsTrue() == 3)
            throw new TrailFeatureException();
    }


    @Override
    public Feature patchUpdate(UUID id, Optional<String> name, Optional<Boolean> trail, Optional<Float> amount, Optional<Boolean> trailRace) {
        Feature toEdit = this.featureRepository.findById(id).orElseThrow(InvalidFeatureIdException::new);

        name.ifPresent((newName) -> this.patchFeatureNameConstraintCheck(toEdit.getName(), newName));
        trail.ifPresent((isTrail) -> this.patchFeatureTrailConstraint(toEdit.isTrail(), isTrail));

        name.ifPresent(toEdit::setName);
        trail.ifPresent(toEdit::setTrail);
        amount.ifPresent(toEdit::setAmount);
        trailRace.ifPresent(toEdit::setTrailRace);

        return this.featureRepository.save(toEdit);
    }

    @Override
    public void delete(UUID id) {
        this.featureRepository.deleteById(id);
    }

    @Override
    public elena.rtoska.trail_races_project.model.vm.Page<Feature> getAll(int page, int size) {
        if(size > 10)
            throw new InvalidPageException();
        Page<Feature> repoPage = this.featureRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
        return new elena.rtoska.trail_races_project.model.vm.Page<>(page, repoPage.getTotalPages(), size, repoPage.getContent());
    }

    @Override
    public Feature getById(UUID id) {
        return this.featureRepository.findById(id).orElseThrow(InvalidFeatureIdException::new);
    }

    @Override
    public elena.rtoska.trail_races_project.model.vm.Page<Feature> getTrail() {
        int size = this.featureRepository.countAllByTrailIsTrue();
        Page<Feature> repoPage = this.featureRepository.findAllByTrailIsTrue(PageRequest.of(0, size, Sort.by("name")));
        return new elena.rtoska.trail_races_project.model.vm.Page<>(0, repoPage.getTotalPages(), size, repoPage.getContent());
    }

    @Override
    public List<Feature> getTrailRace() {
        return this.featureRepository.findAllByTrailRaceIsTrue();
    }

    @Override
    public List<Feature> getCommonFeaturesBetween(UUID race1Id, UUID race2Id) {
        Race p1 = this.raceRepository.findById(race1Id).orElseThrow(InvalidRaceIdException::new);
        Race p2 = this.raceRepository.findById(race2Id).orElseThrow(InvalidRaceIdException::new);
        return this.featureRepository.findAllByRacesContainsAndRacesContains(p1, p2);
    }

    @Override
    public List<Feature> getAll() {
        return this.featureRepository.findAll();
    }
}
