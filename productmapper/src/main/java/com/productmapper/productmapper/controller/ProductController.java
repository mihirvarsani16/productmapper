package com.productmapper.productmapper.controller;

import java.util.List;

import com.productmapper.productmapper.entity.Item;
import com.productmapper.productmapper.entity.Product;
import com.productmapper.productmapper.entity.ProductDto;
import com.productmapper.productmapper.mapper.ProductMapper;
import com.productmapper.productmapper.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<?> saveproduct(@RequestBody ProductDto productDto) {

        Product product = this.productMapper.dtoToModel(productDto);

        // ProductDto productDto1 = this.productMapper.modelToDto(product);
        for (Item i : product.getItems()) {
            i.setProduct(product);
        }
        this.productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body("successfully add");
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll() {

        List<ProductDto> productDto = this.productMapper.modelToDtos(productRepository.findAll());

        return ResponseEntity.status(HttpStatus.FOUND).body(productDto);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findId(@PathVariable int id) {

        ProductDto productDto = this.productMapper.modelToDto(productRepository.findById(id));
        productDto.getItemDtos();
        System.out.println("dto : " + productDto.getItemDtos());

        return ResponseEntity.status(HttpStatus.FOUND).body(productDto);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {

        // ProductDto productDto =
        // this.productMapper.modelToDto(productRepository.findById(id));

        Product product = this.productRepository.findById(id);

        if (product == null) {

            return ResponseEntity.ok().body("this id is not available in data base");

        } else {

            this.productRepository.deleteById(id);
            return ResponseEntity.ok().body("sucessfully deleted");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDto productDto, @PathVariable int id) {

        Product product = this.productRepository.findById(id);

        if (product == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {

            Product product1 = this.productMapper.dtoToModel(productDto);
            product1.setId(id);
            this.productRepository.save(product1);

            return ResponseEntity.status(HttpStatus.OK).body(product1);
        }

    }

}
