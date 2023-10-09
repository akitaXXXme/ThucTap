package backendauth.controllers;

import backendauth.models.OrderStatus;
import backendauth.services.implement.OrderStatusServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/order-status")
@CrossOrigin("*")
public class OrderStatusController {
    @Autowired
    private OrderStatusServiceImp orderStatusServiceImp;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderStatus> AllStatus(){
        return orderStatusServiceImp.AllStatus();
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewStatus(OrderStatus newStatus){
        return orderStatusServiceImp.NewStatus(newStatus);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeStatus(OrderStatus reStatus){
        return orderStatusServiceImp.RemakeStatus(reStatus);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteStatus(int idDel){
        return orderStatusServiceImp.DeleteStatus(idDel);
    }

}
