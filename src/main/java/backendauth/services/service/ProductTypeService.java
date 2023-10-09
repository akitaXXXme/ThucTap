package backendauth.services.service;

import backendauth.models.ProductType;

import java.util.List;

public interface ProductTypeService {
    public List<ProductType> AllType();

    public String NewType(ProductType newType);

    public String RemakeType(ProductType reType);
    public String DeleteType(int idType);
}
