package com.productmapper.productmapper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    @Id
    private int id;
    private String name;
    private String description;
    private int quantity;
    private long price;

    private List<ItemDto> itemDtos = new ArrayList<>();

}
