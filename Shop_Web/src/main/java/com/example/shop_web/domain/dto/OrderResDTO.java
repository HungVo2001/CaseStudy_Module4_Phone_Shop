package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.LocationRegion;
import com.example.shop_web.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResDTO {
    private Long id;
    private UserResDTO user;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    private BigDecimal totalAmount;
    private String shippingCode;

    private String receiverName;
    private String email;
    private String phone;

    private LocationRegionDTO locationRegion;
    private List<OrderDetailResDTO> orderDetails;


    public OrderResDTO(Long id, User user, LocalDateTime orderDate, BigDecimal totalAmount, String shippingCode, String receiverName, String email, String phone, LocationRegion locationRegion) {
        this.id = id;
        this.user = user.toUserResDTO();
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.shippingCode = shippingCode;
        this.receiverName = receiverName;
        this.email = email;
        this.phone = phone;
        this.locationRegion = locationRegion.locationRegionDTO();
    }
}
