package com.salesianostriana._4._1.Dtos;

import com.salesianostriana._4._1.Enums.Estado;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Profesional;

import java.time.LocalDateTime;

public record CitaListDto (
        LocalDateTime fechaHora,
        Estado estado,
        Profesional profesional
){
   public static CitaListDto of(Cita cita){
       return new CitaListDto(
               cita.getFechaHora(),
               cita.getEstado(),
               cita.getProfesional()
       );
   }

}
