package backendauth.services.service;

import backendauth.models.Payment;
import backendauth.models.ProductImage;

import java.util.List;

public interface ProductImageService {
    public List<ProductImage> AllByProduct(int idP);

    public String NewImage(ProductImage newImage);

    public String RemakeImage(ProductImage reImage);
    public String DeleteImage(int idImage);
}
