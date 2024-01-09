package org.sparta.hanghae99lv5.repository;

import org.sparta.hanghae99lv5.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Page<Goods> findAll(Pageable pageable);
}
