package backendauth.services.service;

import backendauth.models.Carts;


import java.util.List;

public interface CartsService {
    public List<Carts> AllByUser(int idU);

    public String NewCart(Carts newCart);

    public String RemakeCart(Carts reCart);
    public String DeleteCart(int idCart);
}
