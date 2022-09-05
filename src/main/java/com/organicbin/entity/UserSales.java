package com.organicbin.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_email", nullable = false, referencedColumnName = "email")
    private User userEmail;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryWaste categoryID;

    private Double weight;
    private LocalDate date;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "collector_contact", referencedColumnName = "contact")
    private Collector collectorContact;
}
