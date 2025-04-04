package tcc_analisi_diseno_software.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc_analisi_diseno_software.Model.Entities.Ubicacion;
import tcc_analisi_diseno_software.Service.UbicacionService;

import java.util.List;

@RestController
@RequestMapping("/ubicacion")
@Tag(name = "Ubicaciones", description = "API para gestionar las ubicaciones de los computadores  ")
public class ControllerUbicacion {

    private final UbicacionService ubicacionService;

    public ControllerUbicacion(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las ubicaciones  ", description = "Devuelve una lista de todos las ubicaciones en el sistema.")
    public ResponseEntity<List<Ubicacion>> getUbicacion() {
        List<Ubicacion> ubicacion = ubicacionService.getUbicacion();
        return ResponseEntity.ok(ubicacion);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener todos las ubicaciones por ID ", description = "Devuelve las ubicaciones  en el sistema por su ID.")
    public ResponseEntity<Ubicacion> getUbicacionById(@PathVariable Long id) {
        Ubicacion ubicacion = ubicacionService.getUbicacionbyId(id);
        return ResponseEntity.ok(ubicacion);
    }


    @PostMapping("/ubicaciones")
    @Operation(summary = "guardar una ubicacion ", description = "guarda  una ubicacion en el sistema .")
    public ResponseEntity<String> addUbicacion(@RequestBody Ubicacion ubicacion) {
        ubicacionService.addUbicacion(ubicacion);
        return ResponseEntity.status(HttpStatus.OK).body("ubicacion  guardado exitosamente");

    }
    @PutMapping("/{id}")
    @Operation(summary = "actualiza la ubicacion  por su ID ", description = "actualiza la ubicacion por su ID.")
    public ResponseEntity<Ubicacion> updateUbicacion(@RequestBody Ubicacion ubicacion, @PathVariable Long id) {
        Ubicacion ubicacionExistente = ubicacionService.getUbicacionbyId(id);


        ubicacionExistente.setNombre(ubicacion.getNombre());
        ubicacionExistente.setActivo(ubicacion.isActivo());

        Ubicacion ubicacionActualizada = ubicacionService.updateUbicacion(ubicacionExistente);
        return ResponseEntity.ok(ubicacionActualizada);

    }
    @DeleteMapping("/{id}/desactivar-ubicacion")
    @Operation(summary = "desactiva  la ubicacion  por su ID ", description = "desactiva  la ubicacion por su ID.")
    public ResponseEntity<String> desactivarUbicacionById(@PathVariable Long id) {
        ubicacionService.desactivarUbicacion(id);
        return ResponseEntity.ok("OK");
    }
    @PutMapping("/{id}/activar-ubicacion")
    @Operation(summary = "activa  la ubicacion  por su ID ", description = "activa  una  ubicacion que este desactivada  por su  ID.")
    public ResponseEntity<String> activarUbicacionById(@PathVariable Long id) {
        ubicacionService.activarUbicacion(id);
        return ResponseEntity.ok("OK");
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "elimina  la ubicacion  por su ID ", description = "elimina definitivamente  la ubicacion por su ID.")
    public ResponseEntity<String> deleteUbicacionById(@PathVariable Long id) {
        ubicacionService.deleteUbicacion(id);
        return ResponseEntity.ok("OK");
    }

}
