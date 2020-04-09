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
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private UUID id;

    @Column(name = "group_name")
    private String name;

    @Column(name = "group_members")
    private Integer members;


    @OneToMany
    @JoinColumn(name="group_id")
    public List<Organizer> organizers;

    @ManyToOne
    @JoinColumn(name="director_id", insertable = false, updatable = false)
    public Director director;


    public Group(String name, Integer members, List<Organizer> organizers) {
        this.name = name;
        this.members=members;
        this.organizers=organizers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group that = (Group) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
