package backendauth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user_acc")

public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_acc_id;
    @Column
    private String full_name;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private LocalDateTime created_at;
    @Column
    private LocalDateTime update_at;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_account_application_user"))
    @JsonIgnoreProperties
    private ApplicationUser applicationUser;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
    @JsonIgnore
    private Set<Order> orderSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
    @JsonIgnore
    private Set<ProductReview> productReviewSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
    @JsonIgnore
    private Set<Carts> cartsSet;

    public int getUser_acc_id() {
        return user_acc_id;
    }

    public void setUser_acc_id(int user_acc_id) {
        this.user_acc_id = user_acc_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Set<ProductReview> getProductReviewSet() {
        return productReviewSet;
    }

    public void setProductReviewSet(Set<ProductReview> productReviewSet) {
        this.productReviewSet = productReviewSet;
    }

    public Set<Carts> getCartsSet() {
        return cartsSet;
    }

    public void setCartsSet(Set<Carts> cartsSet) {
        this.cartsSet = cartsSet;
    }

}
