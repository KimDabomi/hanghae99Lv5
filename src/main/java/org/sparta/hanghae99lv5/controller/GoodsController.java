package org.sparta.hanghae99lv5.controller;

import org.sparta.hanghae99lv5.dto.GoodsRequestDto;
import org.sparta.hanghae99lv5.dto.GoodsResponseDto;
import org.sparta.hanghae99lv5.entity.Goods;
import org.sparta.hanghae99lv5.message.SuccessMessage;
import org.sparta.hanghae99lv5.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<GoodsResponseDto>> getGoodsListSorted(
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        List<GoodsResponseDto> goodsResponseDtoList = goodsService.getGoodsListSorted(sort);
        return ResponseEntity.ok(goodsResponseDtoList);
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
