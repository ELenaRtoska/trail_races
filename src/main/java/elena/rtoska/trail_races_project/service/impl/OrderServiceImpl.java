package elena.rtoska.trail_races_project.service.impl;

import elena.rtoska.trail_races_project.model.Order;
import elena.rtoska.trail_races_project.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order placeOrder(String pizzaType, String pizzaSize, String clientName, String address, String phoneNumber, String dateteOfBirth) {
        return new Order(pizzaType, pizzaSize, clientName, address, phoneNumber, dateteOfBirth);
    }

}
