package com.petstay.hotelcanino.Repository;

import com.petstay.hotelcanino.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByUsuarioId(Long usuarioId);
}
