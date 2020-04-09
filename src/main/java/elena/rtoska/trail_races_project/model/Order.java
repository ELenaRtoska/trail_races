package elena.rtoska.trail_races_project.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {

    private UUID orderId;

    private String raceType;

    private String raceSize;

    private String clientName;

    private String clientAddress;

    private String phoneNumber;
    private String dateOfBirth;

    public Order(){
        this.orderId = UUID.randomUUID();
    }

    public Order(String raceType, String raceSize, String clientName, String clientAddress, String phoneNumber, String dateOfBirth) {
        this.raceType = raceType;
        this.raceSize = raceSize;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = UUID.randomUUID();
        this.phoneNumber=phoneNumber;
        this.dateOfBirth=dateOfBirth;
    }
}
