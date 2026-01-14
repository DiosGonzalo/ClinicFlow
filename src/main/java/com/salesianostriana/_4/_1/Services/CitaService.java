package com.salesianostriana._4._1.Services;

import com.salesianostriana._4._1.Enums.Estado;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Consulta;
import com.salesianostriana._4._1.Models.Paciente;
import com.salesianostriana._4._1.Models.Profesional;
import com.salesianostriana._4._1.Repositorios.CitaRepository;
import com.salesianostriana._4._1.Repositorios.ConsultaRepository;
import com.salesianostriana._4._1.Repositorios.PacienteRepository;
import com.salesianostriana._4._1.Repositorios.ProfessionalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CitaService {
    private CitaRepository citaRepository;
    private PacienteRepository pacienteRepository;
    private ProfessionalRepository professionalRepository;
    private ConsultaRepository consultaRepository;

    public Cita crearCita(Long idPaciente, Long idProfesional, LocalDateTime fechaHora, Long idConsulta){
        Profesional profesional = professionalRepository.findById(idProfesional).orElseThrow(EntityNotFoundException::new);
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException :: new);
        Consulta consulta = consultaRepository.findById(idConsulta).orElseThrow(EntityNotFoundException::new)
        if(!profesional.getCitas().stream()
                .filter(n -> n.getFechaHora().isEqual(fechaHora))
                .toList().isEmpty()){
            throw new //Crear Excepcion tiempoCitas
        }
        LocalDate fechaCita = fechaHora.toLocalDate();
        if(paciente.getCitas().stream()
                .map(n -> n.getFechaHora().toLocalDate())
                .filter(n -> n.isEqual(fechaCita))
                .toList().isEmpty()){
            throw new //la misma excepcion de antes
        }
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        if( fechaHora.isBefore(fechaHoraActual)){
            throw new //hora pasada exception
        }

        Cita cita = Cita.builder()
                .paciente(paciente)
                .profesional(profesional)
                .consulta(consulta)
                .estado(Estado.PROGRAMADA)
                .build();

        return cita;
    }

    public void CancelarCita(Long idCita){
        Cita cita = citaRepository.findById(idCita).orElseThrow(EntityNotFoundException::new);
        if (cita.getEstado().equals(Estado.ATENDIDA)) {
            throw  new //ATENDIDA EXCEPTION
        }

        cita.setEstado(Estado.CANCELADA);
    }

    public Consulta registrarConsulta(Long icCita, Long idProfesional, Long idPaciente, String observaciones, String diagnostico){
        Cita cita = citaRepository.findById(idCita).orElseThrow(EntityNotFoundException::new);
        Profesional profesional = professionalRepository.findById(idProfesional).orElseThrow(EntityNotFoundException::new);
        Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(EntityNotFoundException :: new);


        if(cita.getEstado().equals(Estado.CANCELADA) || cita.getEstado().equals(Estado.ATENDIDA)){
            throw new AlredyAttendedException;
        }

        cita.setEstado(Estado.ATENDIDA);
        Consulta consulta = Consulta.builder()
                .fecha(cita.getFechaHora())
                .diagnostico(diagnostico)
                .observaciones(observaciones)
                .build();
        return consulta;
    }


}
