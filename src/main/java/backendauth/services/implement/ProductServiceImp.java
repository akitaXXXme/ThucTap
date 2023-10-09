package backendauth.services.implement;

import backendauth.models.Product;
import backendauth.repository.ProductRepository;
import backendauth.repository.ProductTypeRepository;
import backendauth.services.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<Product> All() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> AllByType(int idType) {
        List<Product> Result = new ArrayList<>();
        for (Product x : productRepository.findAll()){
            if(x.getProductType().getProduct_type_id() == idType){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewProduct(Product newProduct) {
        newProduct.setCreated_at(LocalDateTime.now());
        productRepository.save(newProduct);
        return null;
    }

    @Override
    public String RemakeProduct(Product remakeProduct) {
        int id_remake = remakeProduct.getProduct_id();
        Optional<Product> optional =productRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "khong ton tai san pham de sua";
        }else{
            Product oldProduct = productRepository.findById(id_remake).get();
            oldProduct = remakeProduct;
            oldProduct.setUpdate_at(LocalDateTime.now());
            productRepository.save(oldProduct);
            return "Sua san pham thanh cong";
        }

    }

    @Override
    public String DeleteProduct(int idProduct) {
        Optional<Product> optional = productRepository.findById(idProduct);
        if(optional.isEmpty()){
            return "Khong ton tai de xoa";
        }else{
            productRepository.deleteById(idProduct);
            return "Xoa thanh cong";
        }

    }
}
