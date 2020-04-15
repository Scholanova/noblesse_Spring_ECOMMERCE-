package com.scholanova.ecommerce.order.entity;

import com.scholanova.ecommerce.cart.entity.Cart;
import com.scholanova.ecommerce.order.CartItem;
import com.scholanova.ecommerce.order.exception.NotAllowedExceptionIfStatusIsClosed;
import com.scholanova.ecommerce.product.entity.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrdersTest {

    @Test
    //done
    public void checkout_ShouldSetTheDateAndTimeOfTodayInTheOrder(){
        //given
        Orders order= new Orders();

        //when
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        order.checkout();

        //then

        assertThat(order.getIssueDate()).isEqualTo(date);
    }

    @Test
    //done
    public void checkout_ShouldSetOrderStatusToPending(){

        //given
        Orders order= new Orders();

        //when
        order.checkout();

        //then

        assertThat(order.getStatus()).isEqualTo(OrderStatus.PENDING);
    }

    @Test
    @Disabled
    public void checkout_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

        //given
        Orders order= new Orders();
        order.setStatus(OrderStatus.CLOSED);

        //When & then
        assertThrows(NotAllowedExceptionIfStatusIsClosed.class, () -> {
            order.checkout();
        });
    }

    @Test
    @Disabled
    public void checkout_ShouldThrowIllegalArgExceptionIfCartTotalItemsQuantityIsZERO(){

    }

    @Test
    @Disabled
    public void setCart_ShouldThrowNotAllowedExceptionIfStatusIsClosed(){

    }

    @Test
    @Disabled
    public void createOrder_ShouldSetTheCartInTheOrder(){

        //given
        Orders order= new Orders();
        Cart cart = new Cart();

        //when
        order.createOrder();

        //then

        assertThat(order.getCart()).isEqualTo(cart);

    }

    @Test
    //done
    public void createOrder_ShouldSetStatusToCreated(){
        //given
        Orders order= new Orders();

        //when
        order.createOrder();

        //then

        assertThat(order.getStatus()).isEqualTo(OrderStatus.CREATED);

    }

    @Test
    @Disabled
    public void getDiscount_shouldReturnZEROIFCartTotalPriceIsLessThan100(){

    }

    @Test
    @Disabled
    public void getDiscount_shouldReturn5percentIfCartTotalPriceIsMoreOrEqual100(){

    }

    @Test
    @Disabled
    public void getOrderPrice_shouldReturnTotalPriceWithDiscount(){

        //given
        Orders order= new Orders();
        Cart cart = new Cart();
        Product target = Product.create("target", "target", 10.0f, 0.2f, "EUR");
        target.setId((long) 12);
        Product decoy = Product.create("decoy", "decoy", 12.0f, 0.05f, "EUR");
        decoy.setId((long) 14);
        cart.getCartItems().add(CartItem.create(target, 3));
        cart.getCartItems().add(CartItem.create(decoy, 5));
        BigDecimal tested = cart.getTotalPrice();

        //when
        order.getOrderPrice();

        //then

        assertThat(tested).isEqualTo(BigDecimal.valueOf((10.0 * 1.2 * 3) + (12.0 * 1.05 * 5)).setScale(2, RoundingMode.HALF_EVEN));
    }

    @Test
    //done
    public void close_ShouldSetStatusToClose(){
        //given
        Orders order= new Orders();

        //when
        order.close();

        //then

        assertThat(order.getStatus()).isEqualTo(OrderStatus.CLOSED);

    }

}