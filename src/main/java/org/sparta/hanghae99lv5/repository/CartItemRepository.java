package org.sparta.hanghae99lv5.repository;

import org.sparta.hanghae99lv5.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCartId(Long cartsId);
}