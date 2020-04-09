package elena.rtoska.trail_races_project.repository;

import elena.rtoska.trail_races_project.model.Feature;
import elena.rtoska.trail_races_project.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RaceRepository extends JpaRepository<Race, UUID> {

    public List<Race> findAllByFeaturesContaining(Feature feature);

    public List<Race> findDistinctByFeatures_TrailIsTrue();



    @Query("select p from races p where p.features.size <= :totalFeatures")
    public List<Race> findAllWithFeaturesLessThan(int totalFeatures);
}
