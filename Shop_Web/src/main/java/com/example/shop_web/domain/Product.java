package com.example.shop_web.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;

    @OneToMany(mappedBy = "product")
    private List<Image> images;


    private BigDecimal price;
    private int quantity;
    private String warrantyPeriod;
    private String ram;
    private String size;
    private String color;
    private String camera;
    private String operatingSystem;
    private String pin;
    private Boolean deleted;

    public Product(Long id) {
        this.id = id;
    }

}
