package elena.rtoska.trail_races_project.service;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import elena.rtoska.trail_races_project.model.vm.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RaceService {

    List<Race> getAll();

    Race create(String raceType, String description);

    Race create(String raceType, String description, boolean trailRace, List<UUID> featuresIds);

    List<Race> getAllContainingFeature(UUID featureId);

    Race putUpdate(UUID id, String raceType, String description, boolean trailRace, List<UUID> featuresIds);

    void delete(UUID id);

    Race getById(UUID id);

    List<Race> getAllWithTrailFeature();

    List<Race> getAllWithFeaturesCountLessThan(int totalFeatures);

    elena.rtoska.trail_races_project.model.vm.Page<Race> getAll(int page, int size);




}
