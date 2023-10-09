package backendauth.controllers;

import backendauth.models.CartItem;
import backendauth.services.implement.CartItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart-item")
@CrossOrigin("*")
public class CartItemController {
    @Autowired
    private CartItemServiceImp cartItemServiceImp;

    @GetMapping(value = "/all-by-cart", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartItem> AllByCart(@RequestParam int idC){
        return cartItemServiceImp.AllByCart(idC);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewItem(@RequestBody CartItem newItem){
        return cartItemServiceImp.NewItem(newItem);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeItem(@RequestBody CartItem reItem){
        return cartItemServiceImp.RemakeItem(reItem);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteItem(int idDel){
        return cartItemServiceImp.DeleteItem(idDel);
    }
}
