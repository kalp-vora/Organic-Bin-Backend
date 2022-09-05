package com.organicbin.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="users")
public class User {

    @Id
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Length(min = 1, max = 1)
    private String gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Length(min = 12, max = 12)
    private String contact;

    @ManyToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address addressID;

    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    private Role roleID;

    @CreationTimestamp
    private LocalDateTime creationDate;
}