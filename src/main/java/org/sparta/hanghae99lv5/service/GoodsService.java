package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.GoodsRequestDto;
import org.sparta.hanghae99lv5.dto.GoodsResponseDto;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.ErrorMessage;
import org.sparta.hanghae99lv5.repository.GoodsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    @Transactional
    public GoodsResponseDto createGoods(GoodsRequestDto requestDto) {
        Goods goods = new Goods(requestDto);
        Goods saveGoods = goodsRepository.save(goods);
        return new GoodsResponseDto(saveGoods);
    }

    public Goods getGoods(Long id, GoodsRequestDto requestDto) {
        return findGoods(id);
    }

    public List<GoodsResponseDto> getGoodsListSorted(Sort sort) {
        List<Goods> goodsList = goodsRepository.findAllOrderBy(sort);

        return goodsList.stream()
                .map(goods -> new GoodsResponseDto(goods))
                .collect(Collectors.toList());
    }

    private Goods findGoods(Long id) {
        return goodsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_GOODS_ERROR_MESSAGE.getErrorMessage())
        );
    }
}
