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
@Table(name="orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orderItem_id")
    private Long orderItemId;

    //@ManyToOne
    @JoinColumn(name="order_id")
    private Order order_;

    @Column(name="productName")
    private String productName;

    @Column(name="quantity")
    private int quantity;

    @Column(name="unit_price")
    private float unit_price;

    protected OrderItem() {}

    public OrderItem(Order order, String productName, int quantity, float unit_price) {
        this.order_ = order;
        this.productName = productName;
        this.quantity = quantity;
        this.unit_price = unit_price;
    }

    public Order getOrder() {
        return order_;
    }

    public void setOrder(Order orderToSet) {
        this.order_ = orderToSet;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setUnitPrice(float UnitPriceToSet) {
        this.unit_price = UnitPriceToSet;
    }

}

