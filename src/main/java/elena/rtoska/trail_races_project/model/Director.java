package elena.rtoska.trail_races_project.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "director_id")
    private UUID id;

    @Column(name = "director_name")
    private String name;

    @Column(name = "director_salary")
    private Integer salary;

    @OneToMany
    @JoinColumn(name="director_id")
    public List<Group> groups;

    public Director(String name, Integer salary, List<Group> groups) {
        this.name = name;
        this.salary=salary;
        this.groups=groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director that = (Director) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
