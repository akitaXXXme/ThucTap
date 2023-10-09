package backendauth.services.implement;

import backendauth.models.ProductReview;
import backendauth.repository.ProductReviewRepository;
import backendauth.services.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewServiceImp implements ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Override
    public List<ProductReview> AllByProduct(int idP) {
        List<ProductReview> Result = new ArrayList<>();
        for(ProductReview x : productReviewRepository.findAll()){
            if(x.getProduct().getProduct_id() == idP){
                Result.add(x);
            }
        }
        return Result;
    }

    @Override
    public List<ProductReview> AllByUser(int idU) {
        return null;
    }

    @Override
    public String NewReview(ProductReview newReview) {
        newReview.setCreated_at(LocalDateTime.now());
        productReviewRepository.save(newReview);
        return "Them thanh cong";
    }

    @Override
    public String RemakeReview(ProductReview reReview) {
        int id_remake = reReview.getProduct_review_id();
        Optional<ProductReview> optional = productReviewRepository.findById(id_remake);
        if(optional.isEmpty()){
            return "Khong co danh gia de sua";
        }else{
            ProductReview oldReview = productReviewRepository.findById(id_remake).get();
            oldReview = reReview;
            oldReview.setUpdate_at(LocalDateTime.now());
            productReviewRepository.save(oldReview);
            return "Sua danh gia thanh cong";
        }
    }

    @Override
    public String DeleteReview(int idReview) {
        Optional<ProductReview> optional = productReviewRepository.findById(idReview);
        if(optional.isEmpty()){
            return "khong ton tai de xoa";
        }else{
            productReviewRepository.deleteById(idReview);
            return "Xoa thanh cong";
        }
    }
}
