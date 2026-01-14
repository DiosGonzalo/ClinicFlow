package com.salesianostriana._4._1.Dtos;

import com.salesianostriana._4._1.Enums.Estado;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Consulta;
import com.salesianostriana._4._1.Models.Paciente;
import com.salesianostriana._4._1.Models.Profesional;

import java.time.LocalDateTime;

public record CitaDetailDto(LocalDateTime fechaHora,
                            Estado estado,
                            Profesional profesional,
                            Paciente paciente,
                            Consulta consulta) {
    public static CitaDetailDto of(Cita cita){
        return new CitaDetailDto(
                cita.getFechaHora(),
                cita.getEstado(),
                cita.getProfesional(),
                cita.getPaciente(),
                cita.getConsulta()

        );
    }
}
