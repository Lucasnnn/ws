package bestcommerce.test.modules.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Users extends AbstractEntity {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private boolean active;

    @JsonIgnore
    @ManyToOne
    private Customers customer;

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private String token;

    // Getters e Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
