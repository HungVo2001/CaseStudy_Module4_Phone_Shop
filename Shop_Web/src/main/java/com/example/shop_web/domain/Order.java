package com.example.shop_web.domain;

<<<<<<< HEAD
import com.example.shop_web.domain.enumaration.EStatus;
=======
import com.example.shop_web.domain.enumDomain.EStatus;
>>>>>>> 201b73342554c322b0b1d87c3cf3347c4aca8a5d
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private  User user;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "shipping_code")
    private String shippingCode;
<<<<<<< HEAD
=======
    private String receiverName;
    private String email;
    private String phone;
    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    private LocationRegion locationRegion;
>>>>>>> 201b73342554c322b0b1d87c3cf3347c4aca8a5d

}
