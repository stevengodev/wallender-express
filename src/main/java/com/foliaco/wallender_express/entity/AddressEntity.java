package com.foliaco.wallender_express.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pais", nullable = false)
    private String country;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "barrio", nullable = false)
    private String neighborhood;

}
