package com.petstay.hotelcanino.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pet")
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String raca;
}
