package com.productmapper.productmapper.controller;

import java.util.List;

import com.productmapper.productmapper.entity.Item;
import com.productmapper.productmapper.entity.ItemDto;
import com.productmapper.productmapper.entity.Product;
import com.productmapper.productmapper.mapper.ProductMapper;
import com.productmapper.productmapper.repository.ItemRepository;
import com.productmapper.productmapper.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/item/{id}")
    public ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto, @PathVariable int id) {

        Product product = this.productRepository.findById(id);

        Item item = this.productMapper.dtoToItem(itemDto);

        item.setProduct(product);

        product.getItems().add(item);

        this.productRepository.save(product);

        // this.itemRepository.save(item);

        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    //
    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> allTimes() {
        // List<Item> item = this.itemRepository.findItemByProduct(id);
        List<Item> item = this.itemRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));

        System.out.println("item : " + item);

        List<ItemDto> itemDto = this.productMapper.itemToDtos(item);
        System.out.println("itemdto " + itemDto);

        return ResponseEntity.status(HttpStatus.OK).body(itemDto);
    }

    // find all product item by id
    @GetMapping("/all/{id}")
    public ResponseEntity<List<ItemDto>> allTimesOfProduct(@PathVariable int id) {
        List<Item> item = this.itemRepository.findItemByProduct(id);
        // List<Item> item = this.itemRepository.findAll();

        System.out.println("item : " + item);

        List<ItemDto> itemDto = this.productMapper.itemToDtos(item);
        System.out.println("itemdto " + itemDto);

        return ResponseEntity.status(HttpStatus.OK).body(itemDto);
    }

    // item id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        Item item = this.itemRepository.findByTid(id);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("with this id there is no item available");
        } else {

            this.itemRepository.deleteById(id);
            return ResponseEntity.ok().body("sucessfully deleted");
        }
    }

    // user id
    @PutMapping("/item/{id}")
    public ResponseEntity<?> update(@RequestBody ItemDto itemDto, @PathVariable int id) {

        Product product = this.productRepository.findById(id);

        if (id == 0) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {

            Item item = this.productMapper.dtoToItem(itemDto);

            item.setProduct(product);

            product.getItems().add(item);

            this.productRepository.save(product);

            return ResponseEntity.ok().body("successfully updated");
        }

    }
}
