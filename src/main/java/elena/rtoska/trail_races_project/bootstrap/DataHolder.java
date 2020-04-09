package elena.rtoska.trail_races_project.bootstrap;

import elena.rtoska.trail_races_project.model.*;
import elena.rtoska.trail_races_project.repository.*;
import lombok.Getter;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
public class DataHolder {

    private static List<Race> initialRaces = new ArrayList<>();
    private static List<Feature> initialFeatures = new ArrayList<>();
    private static List<Organizer> initialOrganizers = new ArrayList<>();
    private static List<Group> initialGroups = new ArrayList<>();
    private static List<Director> initialDirector=new ArrayList<>();

    private final FeatureRepository featureRepository;
    private final RaceRepository raceRepository;
    private final OrganizerRepository organizerRepository;
    private final GroupRepository groupRepository;
    private final DirectorRepository directorRepository;




    public DataHolder(FeatureRepository featureRepository, RaceRepository raceRepository, OrganizerRepository organizerRepository, GroupRepository groupRepository, DirectorRepository directorRepository) {
        this.featureRepository = featureRepository;
        this.raceRepository = raceRepository;
        this.organizerRepository=organizerRepository;
        this.groupRepository=groupRepository;
        this.directorRepository=directorRepository;
    }

    @PostConstruct
    public void init(){

        initialFeatures.add(new Feature("karpa", true, 2, true));
        initialFeatures.add(new Feature("pesok", true, 5, true));
        initialFeatures.add(new Feature("kal", true, 1, true));
        initialFeatures.add(new Feature("zemja", true, 2, true));
        initialFeatures.add(new Feature("treva", true, 2, true));
        initialFeatures.add(new Feature("suma", true, 2, true));
        initialFeatures.add(new Feature("ugornica", true, 2, true));
        initialFeatures.add(new Feature("udolnica", true, 2, true));
        initialFeatures.add(new Feature("ramnina", false, 2, false));
        initialFeatures.add(new Feature("livada", false, 2, false));
        initialFeatures.add(new Feature("krivina desno", true, 2, true));
        initialFeatures.add(new Feature("krivina levo", true, 2, true));



        this.featureRepository.saveAll(initialFeatures);


        initialRaces.add(new Race("Kozjak Vertical Kilometre", "3.7km, 1050D+, 1:18:05", initialFeatures.subList(0,3), true));
        initialRaces.add(new Race("Vodno-Matka half marathon", "26km, 1650D+, 4:18:52", initialFeatures.subList(3,4), true));
        initialRaces.add(new Race("Titov Vrv SkyRace", "20km, 1900D+, 4:53:50", initialFeatures.subList(0,5), true));
        initialRaces.add(new Race("La Veia SkyRace - Italy", "31km, 2600D+, 5:33:08", initialFeatures.subList(2,5), true));
        initialRaces.add(new Race("Krali Marko Trails", "34km, 1750D+, 5:14:56", initialFeatures.subList(2,5), true));
        initialRaces.add(new Race("Momata Rock Trail", "20km, 1050D+, 2:58:15", initialFeatures.subList(2,5), true));
        initialRaces.add(new Race("Skopski polumaraton", "21km, 0D+, 1:28:15", initialFeatures.subList(8,10), true));
        initialRaces.add(new Race("Skopski maraton", "42km, 0D+, 1:28:15", initialFeatures.subList(8,11), true));

        initialRaces.add(new Race("Prv do vrv", "7km, 700D+, 38:15",
                initialFeatures.stream()
                        .filter(Feature::isTrailRace)
                        .collect(Collectors.toList()),
                true));

        initialRaces.add(new Race("Kitka Trail Run", "24km, 1200D+, 02:10:00",
                initialFeatures.stream()
                        .filter(Feature::isTrailRace)
                        .collect(Collectors.toList())
                        .subList(0, 4),
                true));

        this.raceRepository.saveAll(initialRaces);


        initialOrganizers.add(new Organizer("Organizer1", 12000, "Team1", initialRaces.subList(0,2)));
        initialOrganizers.add(new Organizer("Organizer2", 16000, "Team2", initialRaces.subList(2,4)));
        initialOrganizers.add(new Organizer("Organizer3", 15000, "Team3", initialRaces.subList(4,6)));
        initialOrganizers.add(new Organizer("Organizer4", 13000, "Team4", initialRaces.subList(6,7)));
        initialOrganizers.add(new Organizer("Organizer5", 19000, "Team5", initialRaces.subList(7,8)));
        initialOrganizers.add(new Organizer("Organizer5", 19000, "Team5", initialRaces.subList(8,9)));
        initialOrganizers.add(new Organizer("Organizer5", 19000, "Team5", initialRaces.subList(9,10)));

        this.organizerRepository.saveAll(initialOrganizers);



        initialGroups.add(new Group("Grpoup1",7,initialOrganizers.subList(0,2)));
        initialGroups.add(new Group("Grpoup2",12,initialOrganizers.subList(2,3)));
        initialGroups.add(new Group("Grpoup3",23,initialOrganizers.subList(3,4)));
        initialGroups.add(new Group("Grpoup4",15,initialOrganizers.subList(4,5)));
        initialGroups.add(new Group("Grpoup5",28,initialOrganizers.subList(5,7)));

        this.groupRepository.saveAll(initialGroups);


        initialDirector.add(new Director("Harry", 30000,initialGroups.subList(0,1)));
        initialDirector.add(new Director("Paul", 28000,initialGroups.subList(1,3)));
        initialDirector.add(new Director("Jon", 33000,initialGroups.subList(3,4)));
        initialDirector.add(new Director("Mark", 35000,initialGroups.subList(4,5)));

        this.directorRepository.saveAll(initialDirector);

    }

}
