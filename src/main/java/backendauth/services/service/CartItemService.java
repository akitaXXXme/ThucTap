package backendauth.services.service;



import backendauth.models.CartItem;

import java.util.List;

public interface CartItemService {
    public List<CartItem> AllByCart(int idC);

    public String NewItem(CartItem newItem);

    public String RemakeItem(CartItem remakeItem);
    public String DeleteItem(int idItem);
}
