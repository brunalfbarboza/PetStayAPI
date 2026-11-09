package com.petstay.hotelcanino.Repository;

import com.petstay.hotelcanino.Model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
