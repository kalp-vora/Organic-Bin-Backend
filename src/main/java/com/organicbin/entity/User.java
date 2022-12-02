package com.organicbin.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Email
    @NotEmpty(message = "Required Email")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Required Password")
    private String password;

    @Column(nullable = false)
    @NotEmpty(message = "Required Name")
    private String name;

    @Length(max = 1)
    private String gender;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    @Length(min = 12, max = 12)
    @NotEmpty(message = "Required Contact no.")
    private String contact;

    @Column(nullable = false)
    @NotEmpty(message = "Required role")
    private String role;

    @CreationTimestamp
    private LocalDateTime creationDate;
}
