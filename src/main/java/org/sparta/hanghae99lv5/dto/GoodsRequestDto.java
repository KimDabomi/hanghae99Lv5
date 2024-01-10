package org.sparta.hanghae99lv5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsRequestDto {
    private String name;
    private int price;
    private String stock;
    private String intro;
    private String category;
}
