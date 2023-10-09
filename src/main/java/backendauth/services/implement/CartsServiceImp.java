package backendauth.services.implement;

import backendauth.models.Carts;
import backendauth.models.UserAccount;
import backendauth.repository.CartsRepository;
import backendauth.repository.UserRepository;
import backendauth.services.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartsServiceImp implements CartsService {
    @Autowired
    private CartsRepository cartsRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Carts> AllByUser(int idU) {
        List<Carts> Result = new ArrayList<>();
        for (Carts x : cartsRepository.findAll()){
            if(x.getUserAccount().getUser_acc_id() == idU){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewCart(Carts newCart) {
        cartsRepository.save(newCart);
        return "Them thanh cong";
    }

    @Override
    public String RemakeCart(Carts reCart) {
        int id_remake = reCart.getCart_id();
        Optional<Carts> optional = cartsRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "Khong co gio hang nay";
        }
        else{
            Carts oldCart = cartsRepository.findById(id_remake).get();
            oldCart = reCart;
            cartsRepository.save(oldCart);
            return "Thay doi thanh cong";
        }
    }

    @Override
    public String DeleteCart(int idCart) {
        Optional<Carts> optional = cartsRepository.findById(idCart);
        if(optional.isEmpty()){
            return "khong co de xoa";
        }else{
            cartsRepository.deleteById(idCart);
            return "xoa thanh cong";
        }

    }
}
