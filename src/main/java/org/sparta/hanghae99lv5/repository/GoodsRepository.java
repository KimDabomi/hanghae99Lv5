package org.sparta.hanghae99lv5.repository;

import org.sparta.hanghae99lv5.entity.Goods;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findAllOrderBy(Sort sort);
}
