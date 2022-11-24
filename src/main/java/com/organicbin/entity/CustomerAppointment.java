package com.organicbin.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerAppointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private CollectionSlot slotId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @NotNull(message = "Required approx weight ")
    private Double approxWeight;

    @ManyToOne
    @JoinColumn(name = "collector_id", referencedColumnName = "id")
    private User collectorId;

    @Column(columnDefinition = "integer default '0' ")
    private Integer status;

}
