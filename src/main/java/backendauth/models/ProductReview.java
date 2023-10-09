package backendauth.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_review")
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_review_id;
    @Column
    private String content_rated;
    @Column
    private int point_evaluation;
    @Column
    private String content_seen;
    @Column
    private int status;
    @Column
    private LocalDateTime created_at;
    @Column
    private LocalDateTime update_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_review_product"))
    @JsonIgnoreProperties
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_product_review_user_account"))
    @JsonIgnoreProperties
    private UserAccount userAccount;

    public int getProduct_review_id() {
        return product_review_id;
    }

    public void setProduct_review_id(int product_review_id) {
        this.product_review_id = product_review_id;
    }

    public String getContent_rated() {
        return content_rated;
    }

    public void setContent_rated(String content_rated) {
        this.content_rated = content_rated;
    }

    public int getPoint_evaluation() {
        return point_evaluation;
    }

    public void setPoint_evaluation(int point_evaluation) {
        this.point_evaluation = point_evaluation;
    }

    public String getContent_seen() {
        return content_seen;
    }

    public void setContent_seen(String content_seen) {
        this.content_seen = content_seen;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}

