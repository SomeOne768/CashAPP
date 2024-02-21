package app.entities;

import java.util.Date;

public class Order{
    private Long orderId;
    private Long clientId;
    private Date purchaseDate;
    private float total;
    private String paymentMethod;

    public Order(Long clientId, Date purchaseDate, float total, String paymentMethod) {
        this.clientId = clientId;
        this.purchaseDate = purchaseDate;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

   
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


