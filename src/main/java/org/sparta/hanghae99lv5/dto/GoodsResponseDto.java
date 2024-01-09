package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import lombok.Setter;
import org.sparta.hanghae99lv5.entity.Goods;

@Getter
public class GoodsResponseDto {
    private Long id;
    private String name;
    private String price;
    private String stock;
    private String intro;
    private String category;

    public GoodsResponseDto(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
        this.stock = goods.getCount();
        this.intro = goods.getIntro();
        this.category = goods.getCategory();
    }
}
