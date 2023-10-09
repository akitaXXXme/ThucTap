package backendauth.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    @Column
    private String name_product;
    @Column
    private double price;
    @Column
    private String avatar_image_product;
    @Column
    private String title;
    @Column
    private int discount;
    @Column
    private int status;
    @Column
    private int number_of_views;
    @Column
    private LocalDateTime created_at;
    @Column
    private LocalDateTime update_at;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id", foreignKey = @ForeignKey(name = "fk_product_product_type"))
    @JsonIgnoreProperties
    private ProductType productType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private Set<OrderDetail> orderDetailSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private Set<ProductImage> productImageSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private Set<ProductReview> productReviewSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonIgnore
    private Set<CartItem> cartItemSet;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvatar_image_product() {
        return avatar_image_product;
    }

    public void setAvatar_image_product(String avatar_image_product) {
        this.avatar_image_product = avatar_image_product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumber_of_views() {
        return number_of_views;
    }

    public void setNumber_of_views(int number_of_views) {
        this.number_of_views = number_of_views;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

    public Set<ProductImage> getProductImageSet() {
        return productImageSet;
    }

    public void setProductImageSet(Set<ProductImage> productImageSet) {
        this.productImageSet = productImageSet;
    }

    public Set<ProductReview> getProductReviewSet() {
        return productReviewSet;
    }

    public void setProductReviewSet(Set<ProductReview> productReviewSet) {
        this.productReviewSet = productReviewSet;
    }

    public Set<CartItem> getCartItemSet() {
        return cartItemSet;
    }

    public void setCartItemSet(Set<CartItem> cartItemSet) {
        this.cartItemSet = cartItemSet;
    }
}
