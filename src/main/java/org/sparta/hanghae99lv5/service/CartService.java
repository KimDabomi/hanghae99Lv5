package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemResponseDto;
import org.sparta.hanghae99lv5.entity.CartItem;
import org.sparta.hanghae99lv5.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;

    public List<CartItemResponseDto> getCartItemListByCartId(Long cartId) {
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cartId);
        return cartItemList.stream().map(CartItemResponseDto::new).toList();
    }
}
