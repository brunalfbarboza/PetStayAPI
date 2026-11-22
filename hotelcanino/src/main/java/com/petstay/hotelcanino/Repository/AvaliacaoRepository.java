package com.petstay.hotelcanino.Repository;

import com.petstay.hotelcanino.Model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<com.petstay.hotelcanino.Model.Avaliacao> findAllByOrderByCriadoEmDesc();
}