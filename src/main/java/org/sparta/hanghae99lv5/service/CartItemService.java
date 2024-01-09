package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.CartItemRequestDto;
import org.sparta.hanghae99lv5.entity.CartItem;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.ErrorMessage;
import org.sparta.hanghae99lv5.repository.CartItemRepository;
import org.sparta.hanghae99lv5.repository.GoodsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final GoodsRepository goodsRepository;
    @Transactional
    public void createCartItem(CartItemRequestDto requestDto, Long goodsId) {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_GOODS_ERROR_MESSAGE.getErrorMessage()));
        CartItem cartItem = new CartItem(requestDto,goods);
        cartItemRepository.save(cartItem);
    }
}
