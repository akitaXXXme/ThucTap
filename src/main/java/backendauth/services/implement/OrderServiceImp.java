package backendauth.services.implement;

import backendauth.models.Order;
import backendauth.repository.OrderRepository;
import backendauth.repository.UserRepository;
import backendauth.services.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Order> AllByUser(int idU) {
        List<Order> Result = new ArrayList<>();
        for(Order x : orderRepository.findAll()){
            if(x.getUserAccount().getUser_acc_id() == idU){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewOrder(Order newOrder) {
        newOrder.setCreated_at(LocalDateTime.now());
        orderRepository.save(newOrder);
        return "Them thanh cong";
    }

    @Override
    public String RemakeOrder(Order reOrder) {
        int id_remake = reOrder.getOrder_id();
        Optional<Order> optional = orderRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "Khong co order de sua";
        }else{
            Order oldOrder = orderRepository.findById(id_remake).get();
            oldOrder = reOrder;
            oldOrder.setUpdate_at(LocalDateTime.now());
            orderRepository.save(oldOrder);
            return "Sua Thanh cong";
        }
    }

    @Override
    public String DeleteOrder(int idOrder) {
        Optional<Order> optional = orderRepository.findById(idOrder);
        if(optional.isEmpty()){
            return "Khong co de xoa";
        }else{
            orderRepository.deleteById(idOrder);
            return "Xoa thanh cong";
        }
    }
}
