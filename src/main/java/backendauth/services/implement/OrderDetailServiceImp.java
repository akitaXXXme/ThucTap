package backendauth.services.implement;

import backendauth.models.OrderDetail;
import backendauth.repository.OrderDetailRepository;
import backendauth.repository.OrderRepository;
import backendauth.services.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrderDetailServiceImp implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDetail> AllByOrder(int idO) {
        List<OrderDetail> Result = new ArrayList<>();
        for (OrderDetail x : orderDetailRepository.findAll()){
            if(x.getOrder().getOrder_id() == idO){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewDetail(OrderDetail newDetail) {
        newDetail.setUpdate_at(LocalDateTime.now());
        orderDetailRepository.save(newDetail);
        return "Them thanh cong";
    }

    @Override
    public String RemakeDetail(OrderDetail reDetail) {
        int id_remake = reDetail.getOrder_detail_id();
        Optional<OrderDetail> optional =orderDetailRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "khong co de sua";
        }
        else{
            OrderDetail oldDetail = orderDetailRepository.findById(id_remake).get();
            oldDetail =reDetail;
            oldDetail.setUpdate_at(LocalDateTime.now());
            orderDetailRepository.save(oldDetail);
            return "Sua thanh cong";
        }
    }

    @Override
    public String DeleteDetail(int idDetail) {
        Optional<OrderDetail> optional = orderDetailRepository.findById(idDetail);
        if(optional.isEmpty()){
            return "khong ton tai de xoa";
        }else{
            orderDetailRepository.deleteById(idDetail);
            return "Xoa thanh cong";
        }
    }
}
