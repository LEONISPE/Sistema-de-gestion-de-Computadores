package tcc_analisi_diseno_software.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc_analisi_diseno_software.Model.Entities.Historial_de_uso;
import tcc_analisi_diseno_software.Service.HistorialUsoService;

import java.util.List;

@RestController
@RequestMapping("/historial")
@Tag(name = "historial", description = "API para gestionar el historial de uso del los computadores  ")
public class ControllerHistorialUso {

    private final HistorialUsoService historialUsoService;

    public ControllerHistorialUso(HistorialUsoService historialUsoService) {
        this.historialUsoService = historialUsoService;
    }

    @GetMapping("/{computador_id}")
    @Operation(summary = "Obtener una lista del historial de uso del computador  ", description = "Devuelve una lista del historial de uso del computador en el sistema.")
    public ResponseEntity<List<Historial_de_uso>> mostarHistorial(@PathVariable Long computador_id) {
        return ResponseEntity.ok(historialUsoService.getHistorialUsobyComputador(computador_id));
    }

    @PostMapping("/{computadorId}")
    @Operation(summary = "guardar el historial  de uso del computador por si ID  ", description = "guarda el historial de  uso del computador por su id.")
    public ResponseEntity<Historial_de_uso> crearHistorial(@PathVariable Long computadorId) {
        Historial_de_uso historialUso = historialUsoService.guardarHistorialUsoById(computadorId);
        return ResponseEntity.status(HttpStatus.CREATED).body(historialUso);
    }
}
