package backendauth.controllers;

import backendauth.models.Payment;
import backendauth.models.ProductType;
import backendauth.services.implement.PaymentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/payment")
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentServiceImp paymentServiceImp;
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String AddType(@RequestBody Payment newPayment){
        return paymentServiceImp.NewPayment(newPayment);
    }
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Payment> AllPayment(){
        return paymentServiceImp.All();
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeType(@RequestBody Payment rePayment){
        return paymentServiceImp.RemakePayment(rePayment);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeletePayment(@RequestParam int idDelete){
        return paymentServiceImp.DeleteType(idDelete);
    }
}
