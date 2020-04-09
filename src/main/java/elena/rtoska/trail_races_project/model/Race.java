package elena.rtoska.trail_races_project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "race_id")
    private UUID id;

    @Column(name = "race_type")
    private String type;

    @Column(name = "race_description")
    private String description;

    @Column(name = "race_trailRace")
    private boolean trailRace;

    @ManyToMany(targetEntity = Feature.class, fetch = FetchType.EAGER)
    private List<Feature> features;

//    @ManyToOne
//    public Organizer organizer;
//
//    public Organizer getOrganizer()
//    {
//        return organizer;
//    }

    @ManyToOne
    @JoinColumn(name="organizer_id", insertable = false, updatable = false)
    public Organizer organizer;

    public Race(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public Race(String type, String description, List<Feature> features, boolean trailRace) {
        this.type = type;
        this.description = description;
        this.features = features;
        this.trailRace = trailRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id.equals(race.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
