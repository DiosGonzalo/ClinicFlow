package com.salesianostriana._4._1.Repositorios;

import com.salesianostriana._4._1.Models.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalRepository extends JpaRepository<Profesional, Long> {
}
