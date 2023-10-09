package backendauth.services.implement;

import backendauth.models.CartItem;
import backendauth.repository.CartItemRepository;
import backendauth.services.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImp implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<CartItem> AllByCart(int idC) {
        List<CartItem> Result = new ArrayList<>();
        for(CartItem x : cartItemRepository.findAll()){
            if(x.getCart().getCart_id() == idC){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewItem(CartItem newItem) {
        newItem.setCreated_at(LocalDateTime.now());
        cartItemRepository.save(newItem);
        return "Them thanh cong item";
    }

    @Override
    public String RemakeItem(CartItem remakeItem) {
        int id_remake = remakeItem.getCart_item_id();
        Optional<CartItem> optional= cartItemRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "Khong co de sua";
        }else{
            CartItem oldItem = cartItemRepository.findById(id_remake).get();
            oldItem = remakeItem;
            oldItem.setUpdate_at(LocalDateTime.now());
            cartItemRepository.save(oldItem);
            return "Sua thanh cong";
        }

    }

    @Override
    public String DeleteItem(int idItem) {
        Optional<CartItem> optional = cartItemRepository.findById(idItem);
        if(optional.isEmpty()){
            return "khong ton tai de xoa";
        }else{
            cartItemRepository.deleteById(idItem);
            return "Xoa thanh cong";
        }
    }
}
