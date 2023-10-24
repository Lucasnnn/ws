package bestcommerce.test.modules.Categories;

import bestcommerce.test.modules.Customers.Customers;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Categories extends AbstractEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
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
}
