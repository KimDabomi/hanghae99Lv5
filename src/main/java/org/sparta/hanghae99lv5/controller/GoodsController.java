package org.sparta.hanghae99lv5.controller;

import org.sparta.hanghae99lv5.dto.GoodsRequestDto;
import org.sparta.hanghae99lv5.dto.GoodsResponseDto;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.SuccessMessage;
import org.sparta.hanghae99lv5.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/admins/goods")
    public ResponseEntity<String> createUser(@RequestBody GoodsRequestDto requestDto) {
        return handleRequest(() -> {
            goodsService.createGoods(requestDto);
            return new ResponseEntity<>(SuccessMessage.CREATE_GOODS_SUCCESS_MESSAGE.getSuccessMessage(), HttpStatus.CREATED);
        });
    }

    @GetMapping("/users/goods/{goodsId}")
    public Goods getGoods(@PathVariable Long goodsId, @RequestBody GoodsRequestDto requestDto) {
        return goodsService.getGoods(goodsId, requestDto);
    }

    @GetMapping("/users/goods")
    public Page<GoodsResponseDto> getSortedAndPagedGoods(Pageable pageable) {
        return goodsService.getGoodsListSortedAndPaged(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
    }

    private ResponseEntity<String> handleRequest(GoodsController.RequestHandler handler) {
        try {
            return handler.handle();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @FunctionalInterface
    private interface RequestHandler {
        ResponseEntity<String> handle();
    }
}
