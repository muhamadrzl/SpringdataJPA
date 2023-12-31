package com.springdatajpa.springboot.reporsitory;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        Product product = new Product();
        product.setName("product1");
        product.setDescription("Product 1 Description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //Save Product
        Product savedObject =  productRepository.save(product);

        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){

        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setName("update product 1");
        product.setDescription("updated product 1 desc");

        productRepository.save(product);
//        System.out.println(savedObject2.getId());
//        System.out.println(savedObject2.toString());
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("product2");
        product.setDescription("product 2 Description");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product3");
        product3.setDescription("product 3 Description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product,product3));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((product)->{
            System.out.println(product.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();

        Product product1 = productRepository.findById(5L).get();
        Product product2 = productRepository.findById(6L).get();

        productRepository.deleteAll(List.of(product1,product2));
    }

    @Test
    void countMethod(){
        Long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        Long id = 7L;
        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}