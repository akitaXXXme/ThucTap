package backendauth.services.service;

import backendauth.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> All();
    public List<Product> AllByType(int idType);
    public String NewProduct(Product newProduct);
    public String RemakeProduct(Product remakeProduct);
    public String DeleteProduct(int idProduct);
}
