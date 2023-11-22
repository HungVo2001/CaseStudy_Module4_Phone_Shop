package com.example.shop_web.domain;


import com.example.shop_web.domain.enumaration.EGender;
import com.example.shop_web.domain.enumaration.ERole;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String fullName;

    private String email;
    private String address;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private EGender gender;
    private Date dob;
    @OneToOne
    @JoinColumn(name = "location_region_id", referencedColumnName = "id", nullable = false)
    private LocationRegion locationRegion;
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
//    private Role role;
    @Enumerated(value = EnumType.STRING)
    private ERole role;
    @Column(name = "deleted", columnDefinition = "TINYINT(1)")
    private Boolean deleted;

}
