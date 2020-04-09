package elena.rtoska.trail_races_project.repository;

import elena.rtoska.trail_races_project.model.Organizer;
import elena.rtoska.trail_races_project.model.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizerRepository extends JpaRepository<Organizer, UUID> {

//    public Page<Organizer> findAllByTrailIsTrue(Pageable pageable);
//
//    public List<Organizer> findAllByTrailRaceIsTrue();
//
//    public List<Organizer> findAllByRacesContainsAndRacesContains(Race p1, Race p2);
//
//    public int countAllByTrailIsTrue();
//
//    public boolean existsByName(String name);

}