package org.sparta.hanghae99lv5.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv5.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {

    private final CartService cartService;
}
