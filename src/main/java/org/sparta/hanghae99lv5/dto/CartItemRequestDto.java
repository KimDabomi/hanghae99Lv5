package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.Cart;
import org.sparta.hanghae99lv5.entity.Goods;

@Getter
public class CartItemRequestDto {
    private Cart cart;
    private Goods goods;
    private int quantity;
}
