package com.example.shop_web.domain;

import com.example.shop_web.domain.enumDomain.EPriceRange;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    private Branch branch;
<<<<<<< HEAD

    @OneToMany(mappedBy = "product")
    private List<Image> images;


=======
>>>>>>> 201b73342554c322b0b1d87c3cf3347c4aca8a5d
    private BigDecimal price;
    private int quantity;
    private String warrantyPeriod;
    private String ram;
    private String size;
    private String color;
    private String camera;
    private String operatingSystem;
    private String pin;
    private EPriceRange ePriceRange;
    private Boolean deleted;

    public Product(Long id) {
        this.id = id;
    }

}
