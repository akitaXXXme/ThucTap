package backendauth.services.implement;

import backendauth.models.OrderStatus;
import backendauth.repository.OrderStatusRepository;
import backendauth.services.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceImp implements OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;
    @Override
    public String NewStatus(OrderStatus newStatus) {
        orderStatusRepository.save(newStatus);
        return "Them thanh cong";
    }

    @Override
    public String RemakeStatus(OrderStatus remakeStatus) {
        int id_remake = remakeStatus.getOrder_status_id();
        Optional<OrderStatus> optional = orderStatusRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "Khong ton tai de sua";
        }
        else {
            OrderStatus oldStatus = orderStatusRepository.findById(id_remake).get();
            oldStatus = remakeStatus;
            orderStatusRepository.save(oldStatus);
            return "Sua thanh cong";
        }
    }

    @Override
    public String DeleteStatus(int idDel) {
        Optional<OrderStatus> optional = orderStatusRepository.findById(idDel);
        if(optional.isEmpty()){
            return "Khong co de xoa";
        }
        else {
            orderStatusRepository.deleteById(idDel);
            return "Xoa thanh cong";
        }

    }

    @Override
    public List<OrderStatus> AllStatus() {
        return orderStatusRepository.findAll();
    }
}
