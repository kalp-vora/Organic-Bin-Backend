package com.organicbin.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City cityID;
    private Integer pincode;
}
