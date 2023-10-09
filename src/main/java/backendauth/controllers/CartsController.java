package backendauth.controllers;

import backendauth.models.Carts;
import backendauth.services.implement.CartsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/carts")
@CrossOrigin("*")

public class CartsController {
    @Autowired
    private CartsServiceImp cartsServiceImp;

    @GetMapping(value = "/get-by-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Carts> CartByUser(@RequestParam int idU){
        return cartsServiceImp.AllByUser(idU);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewCart(@RequestBody Carts newCart){
        return cartsServiceImp.NewCart(newCart);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeCart(@RequestBody Carts reCart){
        return cartsServiceImp.RemakeCart(reCart);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteCart(int idDel){
        return cartsServiceImp.DeleteCart(idDel);
    }
}
