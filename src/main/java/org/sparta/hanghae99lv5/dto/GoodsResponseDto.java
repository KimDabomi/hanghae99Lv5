package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import org.sparta.hanghae99lv5.entity.Goods;

@Getter
public class GoodsResponseDto {
    private Long id;
    private String name;
    private String price;
    private String count;
    private String intro;
    private String category;

    public GoodsResponseDto(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.count = goods.getCount();
        this.intro = goods.getIntro();
        this.category = goods.getCategory();
    }
}
