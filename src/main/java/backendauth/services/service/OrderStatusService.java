package backendauth.services.service;

import backendauth.models.OrderStatus;
import backendauth.models.Payment;

import java.util.List;

public interface OrderStatusService {

    public String NewStatus(OrderStatus newStatus);
    public String RemakeStatus(OrderStatus remakeStatus);
    public String DeleteStatus(int idDel);
    public List<OrderStatus> AllStatus();
}
