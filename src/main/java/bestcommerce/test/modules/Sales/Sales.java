package bestcommerce.test.modules.Sales;

import java.math.BigDecimal;

import bestcommerce.test.modules.Products.Products;
import bestcommerce.test.modules.Shoopers.Shoopers;
import bestcommerce.test.utils.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Entity
public class Sales extends AbstractEntity {

    @Column(precision = 30, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(precision = 30, scale = 2)
    private BigDecimal shippingCost;

    @Column(precision = 4, scale = 2)
    private BigDecimal tax;

    @ManyToOne(fetch = FetchType.LAZY)
    private Products product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shoopers shooper;

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

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Shoopers getShooper() {
        return shooper;
    }

    public void setShooper(Shoopers shooper) {
        this.shooper = shooper;
    }
}
