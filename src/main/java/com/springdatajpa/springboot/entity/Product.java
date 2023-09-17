package com.springdatajpa.springboot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name = "products",
schema = "ecommerce",
uniqueConstraints = {
        @UniqueConstraint(name = "sku_unique",
                         columnNames = "stock_keeping_unit"),
        @UniqueConstraint(name = "name_unique",
                        columnNames = "name")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "product_generator")
    @SequenceGenerator(name = "product_generator",
                        sequenceName = "product_sequence_name",
                        allocationSize = 1)

    private Long id;

    @Column(name= "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @CreationTimestamp
    private LocalDateTime lastUpdated;

}
