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
@Entity(name = "features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feature_id")
    private UUID id;

    @Column(name = "feature_name")
    private String name;

    @Column(name = "feature_trail")
    private boolean trail;

    @Column(name = "feature_amount")
    private float amount;

    @Column(name = "feature_trailRace")
    private boolean trailRace;

    @ManyToMany(mappedBy = "features", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Race> races;


    public Feature(String name, boolean trail, float amount, boolean trailRace) {
        this.name = name;
        this.trail = trail;
        this.amount = amount;
        this.trailRace = trailRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature that = (Feature) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
