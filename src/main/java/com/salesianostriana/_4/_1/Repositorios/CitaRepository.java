package com.salesianostriana._4._1.Repositorios;

import com.salesianostriana._4._1.Models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
