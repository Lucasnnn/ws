package bestcommerce.test.modules.Sales;

import java.math.BigDecimal;

import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Sales extends AbstractEntity {

    @Column(precision = 30, scale = 2)
    private BigDecimal price;

    @Column(precision = 30, scale = 2)
    private BigDecimal shippingCost;

    @Column(precision = 4, scale = 2)
    private BigDecimal tax;

    // Getters e Setters

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
}
