package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.LocationRegion;
import com.example.shop_web.domain.Order;
import com.example.shop_web.domain.User;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.repository.LocationRegionRepository;
import com.example.shop_web.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OderCreDTO {

    private BigDecimal totalAmount;
    private String receiverName;
    private String phone;
    private LocationRegionCreDTO locationRegionCreDTO;

}
