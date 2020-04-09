package elena.rtoska.trail_races_project.service;

import elena.rtoska.trail_races_project.model.Order;

public interface OrderService {
    Order placeOrder(String raceType, String raceSize, String clientName, String address, String phoneNumber, String dateOfBirth);
}
