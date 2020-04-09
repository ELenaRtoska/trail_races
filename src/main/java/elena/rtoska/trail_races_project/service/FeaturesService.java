package elena.rtoska.trail_races_project.service;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.vm.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FeaturesService {

    Feature create(String name, boolean trail, float amount, boolean trailRace);

    Feature patchUpdate(UUID id, Optional<String> name, Optional<Boolean> trail, Optional<Float> amount, Optional<Boolean> trailRace);

    void delete(UUID id);

    elena.rtoska.trail_races_project.model.vm.Page<Feature> getAll(int page, int size);

    Feature getById(UUID id);

    Page<Feature> getTrail();

    List<Feature> getTrailRace();

    List<Feature> getCommonFeaturesBetween(UUID race1Id, UUID race2Id);

    List<Feature> getAll();

}
