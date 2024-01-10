package org.sparta.hanghae99lv5.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.message.SuccessMessage;
import org.sparta.hanghae99lv5.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {

    private final CartItemService cartItemService;

    @PostMapping("/users/goods/{goodsId}/carts/{cartsId}/cart-items")
    public ResponseEntity<String> createCartItem(@RequestBody CartItemRequestDto requestDto, @PathVariable Long cartsId, @PathVariable Long goodsId) {
        cartItemService.createCartItem(requestDto, goodsId, cartsId);
        return new ResponseEntity<>(SuccessMessage.INSERT_CART_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @PutMapping("/users/cart-items/{cartItemId}")
    public ResponseEntity<String> updateCartItem(@RequestBody CartItemRequestDto requestDto, @PathVariable Long cartItemId) {
        cartItemService.updateCartItem(requestDto, cartItemId);
        return new ResponseEntity<>(SuccessMessage.UPDATE_CART_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/cart-items/{cartItemId}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
        return new ResponseEntity<>(SuccessMessage.DELETE_CART_ITEM_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }
}
