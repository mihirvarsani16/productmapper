package com.productmapper.productmapper.entity;

import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemDto {

    @Id
    private int tid;
    private String name;

}
