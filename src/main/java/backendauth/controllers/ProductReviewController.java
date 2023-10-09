package backendauth.controllers;

import backendauth.models.ProductReview;
import backendauth.services.implement.ProductReviewServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/product-review")
@CrossOrigin("*")
public class ProductReviewController {
    @Autowired
    private ProductReviewServiceImp productReviewServiceImp;

    @GetMapping(value = "/all-by-product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductReview> AllByProduct(@RequestParam int idP){
        return productReviewServiceImp.AllByProduct(idP);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String NewReview(@RequestBody ProductReview newReview){
        return productReviewServiceImp.NewReview(newReview);
    }

    @PutMapping(value = "/remake", produces = MediaType.APPLICATION_JSON_VALUE)
    public String RemakeReview(@RequestBody ProductReview reReview){
        return productReviewServiceImp.RemakeReview(reReview);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String DeleteReview(int idDel){
        return productReviewServiceImp.DeleteReview(idDel);
    }
}
