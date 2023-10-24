package bestcommerce.test.modules.Customers;

import java.util.List;

import bestcommerce.test.modules.Stores.Stores;
import bestcommerce.test.modules.users.Users;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customers extends AbstractEntity {

    private String username;

    private String dateBirth;

    @OneToOne(fetch = FetchType.LAZY)
    private Users owner;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Stores> stores;

    // Getters e Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public List<Stores> getStores() {
        return stores;
    }

    public void setStores(List<Stores> stores) {
        this.stores = stores;
    }

}
