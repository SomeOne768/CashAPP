package app.entities;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;


@Entity
@Table(name="orders")
public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="client")
    private Client client;

    @Column(name="purchase_date")
    private Date purchaseDate;

    @Column(name="total")
    private double total;

    @Column(name="payment_method")
    private String paymentMethod;

    @OneToMany(mappedBy = "order_", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public List<OrderItem> getItems()
    {
        return items;
    }

    public void setItems(List<OrderItem> items)
    {
        this.items = items;
    }

    public void addItems(OrderItem item)
    {
        this.items.add(item);
    }

    public Order(Client client, Date purchaseDate, double total, String paymentMethod) {
        this.client = client;
        this.purchaseDate = purchaseDate;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}