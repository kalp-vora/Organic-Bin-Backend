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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City cityId;

    @Column(nullable = false)
    private Integer pincode;

    @Column(nullable = false)
    private String tag;
}
