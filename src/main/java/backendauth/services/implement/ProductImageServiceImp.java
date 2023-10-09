package backendauth.services.implement;

import backendauth.models.ProductImage;
import backendauth.repository.ProductImageRepository;
import backendauth.repository.ProductRepository;
import backendauth.services.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductImageServiceImp implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductImage> AllByProduct(int idP) {
        List<ProductImage> Result = new ArrayList<>();
        for(ProductImage x : productImageRepository.findAll()){
            if(x.getProduct().getProduct_id() == idP){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public String NewImage(ProductImage newImage) {
        newImage.setCreated_at(LocalDateTime.now());
        productImageRepository.save(newImage);
        return "Them anh thanh cong";
    }

    @Override
    public String RemakeImage(ProductImage reImage) {
        int id_remake = reImage.getProduct_image_id();
        Optional<ProductImage> optional = productImageRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "khong co anh de thay the";
        }else{
            ProductImage oldImage = productImageRepository.findById(id_remake).get();
            oldImage = reImage;
            oldImage.setUpdate_at(LocalDateTime.now());
            productImageRepository.save(oldImage);
            return "Thay anh thanh cong";
        }
    }

    @Override
    public String DeleteImage(int idImage) {
        Optional<ProductImage> optional =  productImageRepository.findById(idImage);
        if(optional.isEmpty()){
            return "khong co anh de xoa";
        }
        else {
            productImageRepository.deleteById(idImage);
            return "xoa thanh cong";
        }
    }
}
