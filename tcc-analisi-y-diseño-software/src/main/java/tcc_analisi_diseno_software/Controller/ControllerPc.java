package tcc_analisi_diseno_software.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc_analisi_diseno_software.DTO.PCDTO;
import tcc_analisi_diseno_software.Service.PcService;

import java.util.List;
@SecurityRequirement(name = "BearerAuth")
@RestController
@RequestMapping("/pc")
@Tag(name = "Computadores", description = "API para gestionar las computadoras ")
public class ControllerPc {

    private final PcService pcService;

    public ControllerPc(PcService pcService) {
        this.pcService = pcService;
    }


    @GetMapping
    @Operation(summary = "Obtener todos los computadores ", description = "Devuelve una lista de todos los computadores registrados en el sistema.")
    public ResponseEntity<List<PCDTO>> getPc() {
return ResponseEntity.ok(pcService.getPc());
    }

    @GetMapping("/{id}")
    @Operation(summary = "obtiene el computador por ID ", description = "obtiene  un computador en el sistema por su ID.")
    public ResponseEntity<PCDTO> getPcId(@PathVariable Long id) {
       return ResponseEntity.ok(pcService.getPcById(id));
    }

    @PostMapping
    @Transactional
    @Operation(summary = "Registrar un nuevo computador ", description = "Registra un nuevo computador en el sistema.")
    public ResponseEntity<String> addPc(@RequestBody @Valid  PCDTO pc) {
        pcService.savePc(pc);
        return ResponseEntity.status(HttpStatus.OK).body("pc guardado exitosamente");
    }
    @PutMapping("/{id}")
    @Operation(summary = "actualiza un  computador existente ", description = "actualiza un  computador existente  en el sistema.")
    public ResponseEntity<String> updatePc(@PathVariable Long id, @RequestBody @Valid PCDTO pc) {
   pcService.updatePc(id, pc);
   return ResponseEntity.status(HttpStatus.OK).body("pc actualizado exitosamente");
    }

    @DeleteMapping("/{id}/desactivar")
    @Operation(summary = "desactiva  un  computador ", description = "desactiva o cambia el estado del computador a no funcional .")
    public ResponseEntity<String> deletePc(@PathVariable Long id) {
      pcService.desactivarPc(id);
      return ResponseEntity.status(HttpStatus.OK).body("pc desactivado exitosamente");
    }

    @PutMapping("/id/activar")
    @Operation(summary = "activa un computador desactivado ", description = "activa un nuevo computador que se encontraba fuera de servicio.")
    public ResponseEntity<String> activarPc(@PathVariable Long id) {
        pcService.activarPc(id);
        return ResponseEntity.status(HttpStatus.OK).body("pc activado exitosamente");
    }
}
