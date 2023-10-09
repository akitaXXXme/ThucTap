package backendauth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_type_id;
    @Column
    private String name_product_type;
    @Column
    private String image_type_product;
    @Column
    private LocalDateTime created_at;
    @Column
    private LocalDateTime update_at;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    @JsonIgnore
    private Set<Product> productSet;

    public int getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(int product_type_id) {
        this.product_type_id = product_type_id;
    }

    public String getName_product_type() {
        return name_product_type;
    }

    public void setName_product_type(String name_product_type) {
        this.name_product_type = name_product_type;
    }

    public String getImage_type_product() {
        return image_type_product;
    }

    public void setImage_type_product(String image_type_product) {
        this.image_type_product = image_type_product;
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

}
