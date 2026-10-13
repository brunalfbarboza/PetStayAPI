package com.petstay.hotelcanino.Repository;

import com.petstay.hotelcanino.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
