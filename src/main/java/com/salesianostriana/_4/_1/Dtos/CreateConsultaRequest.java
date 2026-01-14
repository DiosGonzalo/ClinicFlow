package com.salesianostriana._4._1.Dtos;

import com.salesianostriana._4._1.Models.Consulta;

import java.time.LocalDateTime;

public record CreateConsultaRequest(String observaciones,
                                    String diagnostico,
                                    LocalDateTime fecha) {
    public Consulta toEntiy(){
        return new Consulta().builder()
                .diagnostico(this.diagnostico)
                .observaciones(this.observaciones)
                .fecha(this.fecha)
                .build();
    }
}
