package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.dto.CartItemResponseDto;
import org.sparta.hanghae99lv5.entity.Cart;
import org.sparta.hanghae99lv5.entity.CartItem;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.ErrorMessage;
import org.sparta.hanghae99lv5.repository.CartItemRepository;
import org.sparta.hanghae99lv5.repository.CartRepository;
import org.sparta.hanghae99lv5.repository.GoodsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final GoodsRepository goodsRepository;
    private final CartRepository cartRepository;

    @Transactional
    public void createCartItem(CartItemRequestDto requestDto, Long goodsId, Long cartsId) {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_GOODS_ERROR_MESSAGE.getErrorMessage()));
        Cart cart = cartRepository.findById(cartsId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_CART_ERROR_MESSAGE.getErrorMessage()));
        CartItem cartItem = new CartItem(requestDto,goods,cart);
        cartItemRepository.save(cartItem);
    }

    public List<CartItemResponseDto> getCartItemListByCartId(Long cartId) {
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cartId);
        return cartItemList.stream().map(CartItemResponseDto::new).toList();

    @Transactional
    public void updateCartItem(CartItemRequestDto requestDto, Long cartItemId) {
        CartItem cartItem = findCartItem(cartItemId);
        cartItem.update(requestDto);
    }

    @Transactional
    public void deleteCartItem(Long cartItemId) {
        CartItem cartItem = findCartItem(cartItemId);
        cartItemRepository.delete(cartItem);
    }

    private CartItem findCartItem(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_CART_ITEM_ERROR_MESSAGE.getErrorMessage())
        );
    }
}
