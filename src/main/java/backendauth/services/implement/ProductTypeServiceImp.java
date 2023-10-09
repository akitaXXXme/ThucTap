package backendauth.services.implement;

import backendauth.models.ProductType;
import backendauth.repository.ProductTypeRepository;
import backendauth.services.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImp implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> AllType() {
        return productTypeRepository.findAll();
    }

    @Override
    public String NewType(ProductType newType) {
  //      newType.setCreated_at(LocalDateTime.now());
        productTypeRepository.save(newType);
        return "Them moi loai san pham thanh cong !";
    }

    @Override
    public String RemakeType(ProductType reType) {
        int id_type = reType.getProduct_type_id();
        Optional<ProductType> optional = productTypeRepository.findById(id_type);
        if(optional.isEmpty()){
            return "Khong ton tai loai san pham nay @@";
        }
        else
        {
            ProductType oldType = productTypeRepository.findById(id_type).get();
            oldType = reType;
            oldType.setUpdate_at(LocalDateTime.now());
            productTypeRepository.save(oldType);
            return "Sua thanh cong loai san pham";
        }
    }

    @Override
    public String DeleteType(int idType) {
        Optional<ProductType> optional = productTypeRepository.findById(idType);
        if(optional.isEmpty()){
            return "Khong ton tai loai san pham nay de xoa";
        }else{
            productTypeRepository.deleteById(idType);
            return "Xoa thanh cong!!";
        }
    }
}
