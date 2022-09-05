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
public class UserAppointment implements Serializable {

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_email", nullable = false, referencedColumnName = "email")
    private User userEmail;

    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private SlotList slotID;

    @Column(nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "integer default '0' ")
    private Integer status;

}
