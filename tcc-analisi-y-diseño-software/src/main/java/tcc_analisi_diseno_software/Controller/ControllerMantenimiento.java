package tcc_analisi_diseno_software.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc_analisi_diseno_software.DTO.MantenimientoDTO;
import tcc_analisi_diseno_software.Service.MantenimentoService;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento")
@Tag(name = "Mantenimiento", description = "API para gestionar los Mantenimientos de los computadores ")
public class ControllerMantenimiento {


    private final MantenimentoService mantenimentoService;

    public ControllerMantenimiento(MantenimentoService mantenimentoService) {
        this.mantenimentoService = mantenimentoService;
    }


    @GetMapping("/{computador_id}")
    @Operation(summary = "obtiene la lista   de mantenimeinto  del computador por ID ", description = "obtiene   la lista de todos los mantenimientos del computador en el sistema por su ID.")
    public ResponseEntity<List<MantenimientoDTO>> getComputadorId(@PathVariable Long computador_id) {
        return ResponseEntity.ok(mantenimentoService.getMantenimientoByComputadorId(computador_id));
    }

    @PostMapping("/{computador_id}")
    @Operation(summary = "agrega un mantenimiento al  computador su ID ", description = "agrega un mantenimeinto al computador por su id .")
    public ResponseEntity<Void> addMantenimiento(@RequestBody MantenimientoDTO mantenimientoDTO, @PathVariable Long computador_id) {
        mantenimentoService.addMantenimiento(mantenimientoDTO, computador_id);
       return ResponseEntity.status(HttpStatus.CREATED).build();

    }
    @PutMapping("/{computador_id}")
    @Operation(summary = "actualiza el mantenimiento del  computador por ID ", description = "actualiza el mantenimiento  del  computador en el sistema por su ID.")
    public ResponseEntity<Void> updateMantenimiento(@RequestBody MantenimientoDTO mantenimientoDTO, @PathVariable Long computador_id) {
        // Llamar al servicio para actualizar el mantenimiento
        mantenimentoService.updateMantenimiento(mantenimientoDTO, computador_id);

        // Retornar una respuesta sin cuerpo pero con status OK
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{computador_id}/programacion")
    @Operation(summary = "programa un mantenimeinto a futuro al  computador por ID ", description = "programa un proximo mantenimiento al   computador en el sistema por su ID.")
    public ResponseEntity<MantenimientoDTO> programarMantenimiento(@RequestBody MantenimientoDTO mantenimientoDTO, @PathVariable Long computador_id) {
        mantenimentoService.programarMantenimiento(mantenimientoDTO, computador_id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    }


