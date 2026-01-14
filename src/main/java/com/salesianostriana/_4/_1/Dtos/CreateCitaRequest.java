package com.salesianostriana._4._1.Dtos;

import com.salesianostriana._4._1.Enums.Estado;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Consulta;
import com.salesianostriana._4._1.Models.Paciente;
import com.salesianostriana._4._1.Models.Profesional;

import java.time.LocalDateTime;

public record CreateCitaRequest (Profesional profesional,
                                 Paciente paciente,
                                 LocalDateTime fechaHora,
                                 Consulta consulta,
                                 Estado estado){
public Cita toEntity(){
    return Cita.builder()
            .consulta(this.consulta)
            .estado(this.estado)
            .fechaHora(this.fechaHora)
            .profesional(this.profesional)
            .paciente(this.paciente)
            .build();
}
}
