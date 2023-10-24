package bestcommerce.test.modules.costumers;

import bestcommerce.test.config.AbstractEntity;
import bestcommerce.test.modules.users.Users;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Costumers extends AbstractEntity {

    private String username;

    private String dateBirth;

    @OneToOne
    private Users owner;

    // ===== METHODS

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
}
