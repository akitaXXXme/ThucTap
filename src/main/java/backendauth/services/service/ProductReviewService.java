package backendauth.services.service;



import backendauth.models.ProductReview;

import java.util.List;

public interface ProductReviewService {
    public List<ProductReview> AllByProduct(int idP);
    public List<ProductReview> AllByUser(int idU);

    public String NewReview(ProductReview newReview);

    public String RemakeReview(ProductReview reReview);
    public String DeleteReview(int idReview);
}
