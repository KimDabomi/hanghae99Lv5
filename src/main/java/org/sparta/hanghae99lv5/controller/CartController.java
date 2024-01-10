package org.sparta.hanghae99lv5.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.dto.CartItemResponseDto;
import org.sparta.hanghae99lv5.dto.CartResponseDto;
import org.sparta.hanghae99lv5.message.SuccessMessage;
import org.sparta.hanghae99lv5.service.CartItemService;
import org.sparta.hanghae99lv5.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {

    private final CartItemService cartItemService;
    private final CartService cartService;

    @PostMapping("/users/goods/{goodsId}/carts/{cartsId}/cart-items")
    public ResponseEntity<String> createCartItem(@RequestBody CartItemRequestDto requestDto, @PathVariable Long cartsId, @PathVariable Long goodsId) {
        cartItemService.createCartItem(requestDto, goodsId, cartsId);
        return new ResponseEntity<>(SuccessMessage.INSERT_CART_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @GetMapping("/users/carts/{cartId}")
    public List<CartResponseDto> getCartItemListByCartId(@PathVariable Long cartId) {
        return cartService.getCartItemListByCartId(cartId);
    }

}
