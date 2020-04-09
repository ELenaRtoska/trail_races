package elena.rtoska.trail_races_project.repository;

import elena.rtoska.trail_races_project.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
}
