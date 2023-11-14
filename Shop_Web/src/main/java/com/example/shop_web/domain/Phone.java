package com.example.shop_web.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "phones")
@Getter
@Setter
@NoArgsConstructor
//@Where(clause = "deleted = 0")
//@SQLDelete(sql= "UPDATE task SET `deleted` = 1 WHERE (`id` = ?) ")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
