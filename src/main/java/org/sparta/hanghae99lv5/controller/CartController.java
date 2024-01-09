package org.sparta.hanghae99lv5.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.message.SuccessMessage;
import org.sparta.hanghae99lv5.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {

    private final CartItemService cartItemService;

    @PostMapping("/users/cart-items")
    public ResponseEntity<String> createCartItem(@RequestBody CartItemRequestDto requestDto) {
        cartItemService.createCartItem(requestDto);
        return new ResponseEntity<>(SuccessMessage.INSERT_CART_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
    }

}
