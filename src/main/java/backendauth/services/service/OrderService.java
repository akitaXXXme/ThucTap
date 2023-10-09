package backendauth.services.service;


import backendauth.models.Order;

import java.util.List;

public interface OrderService {
    public List<Order> AllByUser(int idU);

    public String NewOrder(Order newOrder);

    public String RemakeOrder(Order reOrder);
    public String DeleteOrder(int idOrder);
}
