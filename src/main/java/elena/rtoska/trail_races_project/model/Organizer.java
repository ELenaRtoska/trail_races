package elena.rtoska.trail_races_project.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organizer_id")
    private UUID id;

    @Column(name = "organizer_name")
    private String name;

    @Column(name = "organizer_salary")
    private Integer salary;

    @Column(name = "organizer_teamName")
    private String teamName;

//    @OneToMany
//    @JoinTable(name="races_organizers", joinColumns={
//            @JoinColumn(name="ID_organizer", referencedColumnName="organizer_id")
//    }, inverseJoinColumns={
//            @JoinColumn(name="ID_race", referencedColumnName="race_id")
//    })
//    @JsonIgnore
//    public List<Race> races;

    @OneToMany
    @JoinColumn(name="organizer_id")
    public List<Race> races;



    @ManyToOne
    @JoinColumn(name="group_id", insertable = false, updatable = false)
    public Group group;



    public Organizer(String name, Integer salary, String teamName, List<Race> races) {
        this.name = name;
        this.salary=salary;
        this.teamName=teamName;
        this.races=races;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer that = (Organizer) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
