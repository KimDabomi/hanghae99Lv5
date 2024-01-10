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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/admins/goods")
    public ResponseEntity<String> createGoods(GoodsRequestDto requestDto, @RequestPart MultipartFile imageFile) {
        return handleRequest(() -> {
            goodsService.createGoods(requestDto,imageFile);
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    private interface RequestHandler {
        ResponseEntity<String> handle() throws IOException;
    }
}
