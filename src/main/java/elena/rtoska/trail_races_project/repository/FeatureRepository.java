package elena.rtoska.trail_races_project.repository;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FeatureRepository extends JpaRepository<Feature, UUID> {

    public Page<Feature> findAllByTrailIsTrue(Pageable pageable);

    public List<Feature> findAllByTrailRaceIsTrue();

    public List<Feature> findAllByRacesContainsAndRacesContains(Race p1, Race p2);

    public int countAllByTrailIsTrue();

    public boolean existsByName(String name);

}
