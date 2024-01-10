package org.sparta.hanghae99lv5.service;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.dto.GoodsRequestDto;
import org.sparta.hanghae99lv5.dto.GoodsResponseDto;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.ErrorMessage;
import org.sparta.hanghae99lv5.repository.GoodsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final ImageS3Service imageS3Service;

    @Transactional
    public void createGoods(GoodsRequestDto requestDto, MultipartFile imageFile) throws IOException {
        Goods goods = new Goods(requestDto, imageS3Service.saveFile(imageFile));
        Goods saveGoods = goodsRepository.save(goods);
        new GoodsResponseDto(saveGoods);
    }

    public Goods getGoods(Long id, GoodsRequestDto requestDto) {
        return findGoods(id);
    }

    public Page<GoodsResponseDto> getGoodsListSortedAndPaged(int page, int size, Sort sort) {
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Goods> goodsPage = goodsRepository.findAll(pageRequest);

        return goodsPage.map(GoodsResponseDto::new);
    }

    private Goods findGoods(Long id) {
        return goodsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(ErrorMessage.EXIST_GOODS_ERROR_MESSAGE.getErrorMessage())
        );
    }
}
