package tcc_analisi_diseno_software.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc_analisi_diseno_software.Model.Entities.Usuario;
import tcc_analisi_diseno_software.Service.ServiceUsuario;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "API para gestionar a los usuarios que tengan acesso al sistema ")
public class UsuarioController {

    private final ServiceUsuario serviceUsuario;

    public UsuarioController(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping
    @Operation(summary = "Listar todos los Usuarios   ", description = "Devuelve una lista de todos los Usuarios en el sistema.")
    public ResponseEntity<List<Usuario>> listar() {
        return  ResponseEntity.ok(serviceUsuario.getUsuarios());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener el usuario por id  ", description = "Devuelve un usuario  por su ID.")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        Usuario usuario = serviceUsuario.getUsuarioById(id);
        return  ResponseEntity.ok(usuario);
    }

    @PostMapping
    @Operation(summary = "guarda un usuario nuevo ", description = "guarda un usuario nuevo en el sistema.")
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario) {
        serviceUsuario.addUsuario(usuario);
        return  ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    @Operation(summary = "actualiza un usuario existente en el sistema  ", description = "hace un update  a un usuario existente.")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado =  serviceUsuario.updateUsuario(id,usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioActualizado);
    }

    @DeleteMapping("/{id}/desactivar")
    @Operation(summary = "desactiva un usuario  ", description = "desactiva un usuario por su id .")
    public ResponseEntity<Usuario> desactivarUsuario(@PathVariable Long id) {
    serviceUsuario.desactivarUsuario(id);
    return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}/activar")
    @Operation(summary = "activa un usuario   ", description = "Activa un usuario que esta desactivado por su id .")
    public ResponseEntity<Usuario> activarUsuario(@PathVariable Long id) {
        serviceUsuario.activarUsuario(id);
        return ResponseEntity.noContent().build();


    }

    @DeleteMapping("/{id}")
    @Operation(summary = "elimina un usuario  ", description = "elimina un usuario denforma permantente por su id .")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        serviceUsuario.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
    }
