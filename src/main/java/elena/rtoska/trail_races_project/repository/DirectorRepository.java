package elena.rtoska.trail_races_project.repository;

import elena.rtoska.trail_races_project.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DirectorRepository extends JpaRepository<Director, UUID>{
}
