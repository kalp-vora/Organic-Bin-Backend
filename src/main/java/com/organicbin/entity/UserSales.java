package com.organicbin.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryWaste categoryId;

    @Column(nullable = false)
    private Double actualWeight;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "collector_contact", referencedColumnName = "contact")
    private User collectorContact;

}
