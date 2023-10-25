package bestcommerce.test.modules.Customers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bestcommerce.test.modules.Stores.Stores;
import bestcommerce.test.modules.users.Users;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customers extends AbstractEntity {

    private String icon;

    private String domain;

    private String hexColor;

    private String platformName;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Users owner;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Stores> stores;

    // Getters e Setters

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

}
