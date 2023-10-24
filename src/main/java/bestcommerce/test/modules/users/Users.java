package bestcommerce.test.modules.users;

import bestcommerce.test.config.AbstractEntity;
import bestcommerce.test.modules.costumers.Costumers;
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

    @ManyToOne
    private Costumers costumer;

    // ===== METHODS

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

    public Costumers getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumers costumer) {
        this.costumer = costumer;
    }
}
