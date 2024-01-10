package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.Cart;
import org.sparta.hanghae99lv5.entity.CartItem;

import java.util.List;

@Getter
public class CartResponseDto {
    private final List<CartItem> cartItem;
    private int totalPrice;

    public CartResponseDto(List<CartItem> cartItem) {
        this.cartItem = cartItem;
        this.totalPrice = cartItem.stream()
                .mapToInt(CartItem::getTotalPrice)
                .sum();
    }
}
