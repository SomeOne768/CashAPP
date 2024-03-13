package app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="purchase_id")
    private Long purchaseId;

    //@ManyToOne
    @JoinColumn(name="order")
    private Order order;

    //@ManyToOne
    @JoinColumn(name="product")
    private Product product;

    @Column(name="quantity")
    private int quantity;

    @Column(name="unit_price")
    private double unit_price;

    protected Purchase() {}

    public Purchase(Order order, Product product, int quantity, double unit_price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order orderToSet) {
        this.order = orderToSet;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productToSet) {
        this.product = productToSet;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantityToSet) {
        this.quantity = quantityToSet;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public void setUnitPrice(double UnitPriceToSet) {
        this.unit_price = UnitPriceToSet;
    }

}

