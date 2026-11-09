package com.petstay.hotelcanino.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "agendamento")
@Data
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private LocalDate dataCriacao;

    private LocalDate dataAgendamento;

    private LocalDate dataDevolucao;

    @PrePersist
    public void onCreate() {
        this.dataCriacao = LocalDate.now();
    }
}
