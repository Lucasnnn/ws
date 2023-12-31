package bestcommerce.test.modules.Stores;

import bestcommerce.test.modules.Adresses.Adresses;
import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Stores extends AbstractEntity {

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Adresses address;

    @ManyToOne
    private Customers customer;

    // Getters e Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Adresses getAddress() {
        return address;
    }

    public void setAddress(Adresses address) {
        this.address = address;
    }
}
