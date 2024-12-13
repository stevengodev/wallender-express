package com.foliaco.wallender_express.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_cedula", nullable = false, unique = true)
    private String idCard;

    @Column(name = "tipo_cedula", nullable = false)
    private String typeIdCard;

    @Column(name = "nombres", nullable = false)
    private String names;

    @Column(name = "apellidos", nullable = false)
    private String lastnames;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefono", nullable = false)
    private String phone;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "foto")
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id",nullable = false)
    private AddressEntity addressEntity;

}
