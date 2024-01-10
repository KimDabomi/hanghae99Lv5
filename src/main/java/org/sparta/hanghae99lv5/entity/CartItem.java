package org.sparta.hanghae99lv5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;

@Entity
@Getter
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Column(name = "quantity")
    private int quantity;

    public CartItem(CartItemRequestDto requestDto, Goods goods, Cart cart) {
        this.cart = cart;
        this.goods = goods;
        this.quantity = requestDto.getQuantity();
    }

    public void update(CartItemRequestDto requestDto) {
        this.quantity = requestDto.getQuantity();
    }
}
