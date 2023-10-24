package bestcommerce.test.modules.Shoopers;

import bestcommerce.test.modules.Adresses.Adresses;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

@Entity
public class Shoopers extends AbstractEntity {

    private String document;

    private String phoneNumber;

    @OneToOne(fetch = FetchType.EAGER)
    private Adresses billingAddress;

    @OneToOne(fetch = FetchType.EAGER)
    private Adresses shippingAddress;

    // Getters e Setters

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Adresses getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Adresses billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Adresses getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Adresses shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
