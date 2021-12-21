package com.productmapper.productmapper.mapper;

import com.productmapper.productmapper.entity.Item;
import com.productmapper.productmapper.entity.ItemDto;
import com.productmapper.productmapper.entity.Product;
import com.productmapper.productmapper.entity.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-20T13:51:44+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto modelToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setDescription( product.getDesc() );
        productDto.setItemDtos( itemToDtos( product.getItems() ) );
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setQuantity( product.getQuantity() );

        return productDto;
    }

    @Override
    public List<ProductDto> modelToDtos(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( product.size() );
        for ( Product product1 : product ) {
            list.add( modelToDto( product1 ) );
        }

        return list;
    }

    @Override
    public Product dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setDesc( productDto.getDescription() );
        product.setItems( itemDtoListToItemList( productDto.getItemDtos() ) );
        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setPrice( productDto.getPrice() );
        product.setQuantity( productDto.getQuantity() );

        return product;
    }

    @Override
    public ItemDto itemToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setName( item.getName() );
        itemDto.setTid( item.getTid() );

        return itemDto;
    }

    @Override
    public List<ItemDto> itemToDtos(List<Item> item) {
        if ( item == null ) {
            return null;
        }

        List<ItemDto> list = new ArrayList<ItemDto>( item.size() );
        for ( Item item1 : item ) {
            list.add( itemToDto( item1 ) );
        }

        return list;
    }

    @Override
    public Item dtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( itemDto.getName() );
        item.setTid( itemDto.getTid() );

        return item;
    }

    protected List<Item> itemDtoListToItemList(List<ItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Item> list1 = new ArrayList<Item>( list.size() );
        for ( ItemDto itemDto : list ) {
            list1.add( dtoToItem( itemDto ) );
        }

        return list1;
    }
}
