package com.salesianostriana._4._1.Repositorios;

import com.salesianostriana._4._1.Models.Cita;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {



    @EntityGraph(attributePaths = {"paciente"})
    List<Cita> findByPacienteId(Long id);


    Page<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin, Pageable pageable);


    Page<Cita> findAllPage( Pageable pageable);
}
