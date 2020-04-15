package com.scholanova.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scholanova.ecommerce.cart.entity.Cart;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name="orders")
public class Orders {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column
    private String number;

    @Column
    private Date issueDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id", referencedColumnName = "id")
    private Cart cart;

    public Orders() {
    }

    public void createOrder(){
        //TODO
        OrderStatus status=OrderStatus.CREATED;
        setStatus(status);
    }

    public void checkout(){
        //TODO
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        setIssueDate(date);

        OrderStatus status=OrderStatus.PENDING;
        setStatus(status);
        /*try
        {

        }
        catch (Exception e)
        {

        }*/
    }

    public void getDiscount(){
        //TODO
    }

    public void getOrderPrice(){
        //TODO
    }

    public void close(){
        //TODO
        OrderStatus status=OrderStatus.CLOSED;
        setStatus(status);
    }


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {return number;}

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getIssueDate() {return issueDate;}

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public OrderStatus getStatus() {return status;}

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Cart getCart() {return cart;}

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
