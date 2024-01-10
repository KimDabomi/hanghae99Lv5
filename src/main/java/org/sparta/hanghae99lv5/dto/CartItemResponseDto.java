package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.Cart;
import org.sparta.hanghae99lv5.entity.CartItem;
import org.sparta.hanghae99lv5.entity.Goods;

@Getter
public class CartItemResponseDto {
    private final Cart cart;
    private final Goods goods;
    private final int quantity;
    private final int price;

    public CartItemResponseDto(CartItem cartItem) {
        this.cart = cartItem.getCart();
        this.goods = cartItem.getGoods();
        this.quantity = cartItem.getQuantity();
        this.price = cartItem.getQuantity() * cartItem.getGoods().getPrice();
    }
}
