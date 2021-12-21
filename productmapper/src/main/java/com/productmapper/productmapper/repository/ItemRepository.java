package com.productmapper.productmapper.repository;

import java.util.List;

import com.productmapper.productmapper.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("from Item as i where i.product.id =:id")
    public List<Item> findItemByProduct(@Param("id") int id);

    public Item findByTid(int id);

}
