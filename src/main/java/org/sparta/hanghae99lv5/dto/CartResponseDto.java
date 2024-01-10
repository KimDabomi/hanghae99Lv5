package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.CartItem;

@Getter
public class CartResponseDto {
    private final CartItem cartItem;
    private int totalPrice;

    public CartResponseDto(CartItem cartItem) {
        this.cartItem = cartItem;
        this.totalPrice += cartItem.getGoods().getPrice() * cartItem.getQuantity();
    }
}
