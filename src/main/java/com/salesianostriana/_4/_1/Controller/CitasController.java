package com.salesianostriana._4._1.Controller;

import com.salesianostriana._4._1.Dtos.CitaListDto;
import com.salesianostriana._4._1.Dtos.CreateConsultaRequest;
import com.salesianostriana._4._1.Models.Cita;
import com.salesianostriana._4._1.Models.Consulta;
import com.salesianostriana._4._1.Repositorios.CitaRepository;
import com.salesianostriana._4._1.Services.CitaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/citas")
public class CitasController {
    private final CitaService citaService;
    private final CitaRepository citaRepository;

    @PostMapping
    public List<CitaListDto> getAll(){
        return citaService.getALl().stream()
                .map(n -> CitaListDto.of(n))
                .toList();
    }

    @PutMapping ("/{id}/cancelar")
    public void cancelarCita(@RequestParam Long idCita){
        citaService.CancelarCita(idCita);
    }

    @PostMapping("/{id}/consulta") // 1. Usar POST y nombre coincidente
    public ResponseEntity<Consulta> crearConsulta(
            @PathVariable Long id,
            @RequestBody CreateConsultaRequest request) { // 2. Recibir el DTO
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(citaService.registrarConsulta(id, request));
    }

    @GetMapping
    public Page<Cita> getAllCitas(@PageableDefault(page = 0, size = 10)
                                      Pageable pageable){
        return citaRepository.findAllPage(pageable);
    }


}
