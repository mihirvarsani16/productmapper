package com.productmapper.productmapper.mapper;

import java.util.List;

import com.productmapper.productmapper.entity.Item;
import com.productmapper.productmapper.entity.ItemDto;
import com.productmapper.productmapper.entity.Product;
import com.productmapper.productmapper.entity.ProductDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({

            @Mapping(target = "description", source = "product.desc"),
            @Mapping(target = "itemDtos", source = "product.items")
    })
    ProductDto modelToDto(Product product);

    List<ProductDto> modelToDtos(List<Product> product);

    @InheritInverseConfiguration(name = "modelToDto")
    Product dtoToModel(ProductDto productDto);

    ItemDto itemToDto(Item item);

    List<ItemDto> itemToDtos(List<Item> item);

    Item dtoToItem(ItemDto itemDto);

}
