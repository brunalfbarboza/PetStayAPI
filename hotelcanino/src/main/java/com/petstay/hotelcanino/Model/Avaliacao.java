package com.petstay.hotelcanino.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacoes")
@Data
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String tutor;

    @Column(nullable = false, length = 120)
    private String pet;

    @Column(nullable = false, length = 120)
    private String servico;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criadoEm;

    @PrePersist
    protected void onCreate() {
        this.criadoEm = LocalDateTime.now();
    }

    public Avaliacao() {
    }

    public Avaliacao(String tutor, String pet, String servico, Integer nota, String comentario) {
        this.tutor = tutor;
        this.pet = pet;
        this.servico = servico;
        this.nota = nota;
        this.comentario = comentario;
    }
}