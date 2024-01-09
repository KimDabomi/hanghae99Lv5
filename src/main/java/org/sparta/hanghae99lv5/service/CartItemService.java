package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.entity.CartItem;
import org.sparta.hanghae99lv5.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Transactional
    public void createCartItem(CartItemRequestDto requestDto) {
        CartItem cartItem = new CartItem(requestDto);
        cartItemRepository.save(cartItem);
    }
}
