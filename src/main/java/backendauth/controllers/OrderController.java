package backendauth.controllers;

import backendauth.models.Order;
import backendauth.services.implement.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @GetMapping(value = "/all-by-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> AllByUser(@RequestParam int idU){
        return orderServiceImp.AllByUser(idU);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewOrder(@RequestBody Order newOrder){
        return orderServiceImp.NewOrder(newOrder);
    }
    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeOrder(@RequestBody Order reOrder){
        return orderServiceImp.RemakeOrder(reOrder);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteOrder(@RequestParam int idDel){
        return orderServiceImp.DeleteOrder(idDel);
    }
}
