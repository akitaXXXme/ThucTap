package backendauth.controllers;

import backendauth.models.OrderDetail;
import backendauth.services.implement.OrderDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/order-detail")
@CrossOrigin("*")
public class OrderDetailController {
    @Autowired
    private OrderDetailServiceImp orderDetailServiceImp;

    @GetMapping(value = "/all-by-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetail> AllByOrder(@RequestParam int idO){
        return orderDetailServiceImp.AllByOrder(idO);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewODetail(@RequestBody OrderDetail newDetail){
        return orderDetailServiceImp.NewDetail(newDetail);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeODetail(@RequestBody OrderDetail reODetail){
        return orderDetailServiceImp.RemakeDetail(reODetail);
    }
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteODetail(@RequestParam int idDel){
        return orderDetailServiceImp.DeleteDetail(idDel);
    }
}
