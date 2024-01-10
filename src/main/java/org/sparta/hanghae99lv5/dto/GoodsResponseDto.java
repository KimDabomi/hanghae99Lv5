package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import lombok.Setter;
import org.sparta.hanghae99lv5.entity.Goods;

@Getter
public class GoodsResponseDto {
    private final Long id;
    private final String name;
    private final int price;
    private final String stock;
    private final String intro;
    private final String category;

    public GoodsResponseDto(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.stock = goods.getStock();
        this.intro = goods.getIntro();
        this.category = goods.getCategory();
    }
}
