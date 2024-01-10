package org.sparta.hanghae99lv5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sparta.hanghae99lv5.dto.GoodsRequestDto;

@Entity
@Getter
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String stock;

    @Column(nullable = false)
    private String intro;

    @Column(nullable = false)
    private String category;

    @Column
    private String url;


    public Goods(GoodsRequestDto requestDto, String url) {
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.stock = requestDto.getStock();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
        this.url = url;
    }
}
