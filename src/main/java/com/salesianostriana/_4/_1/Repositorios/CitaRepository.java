package com.salesianostriana._4._1.Repositorios;

import com.salesianostriana._4._1.Dtos.CitaListDto;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query("""
            SELECT c
                FROM Cita
                WHERE c.estado = :status
            """)
    @EntityGraph(attributePaths = {"paciente"})
    List<Cita> buscarCitaPorEstado(@Param("status")String status);

    @EntityGraph(attributePaths = {"paciente"})
    List<Cita> findByPacienteId(Long id);


    Page<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin, Pageable pageable);


}
