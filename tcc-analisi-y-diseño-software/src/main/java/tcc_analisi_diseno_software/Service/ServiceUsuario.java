package tcc_analisi_diseno_software.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.Model.Entities.Usuario;
import tcc_analisi_diseno_software.Model.Repository.RepoUsuario;

import java.util.List;

@Service
public class ServiceUsuario {


    private final RepoUsuario repoUsuario;
    private final PasswordEncoder passwordEncoder;

    public ServiceUsuario(RepoUsuario repoUsuario, PasswordEncoder passwordEncoder) {
        this.repoUsuario = repoUsuario;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getUsuarios() {
        return  repoUsuario.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return repoUsuario.findById(id).get();
    }

    public Usuario addUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return repoUsuario.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario  usuario1 = repoUsuario.findById(id).get();
        usuario1.setNombre(usuario.getNombre());
        usuario1.setCorreo(usuario.getCorreo());
        usuario1.setUsername(usuario.getUsername());
        usuario1.setPassword(usuario.getPassword());
 return repoUsuario.save(usuario1);
    }

    public void desactivarUsuario(Long id) {
       Usuario usuario = repoUsuario.getReferenceById(id);
       usuario.setActivo(false);
       repoUsuario.save(usuario);

    }

    public void activarUsuario(Long id) {
        Usuario usuario = repoUsuario.getReferenceById(id);
        if(usuario.isActivo()){
            throw  new RuntimeException("El usuario ya esta activo");
        }
        usuario.setActivo(true);
        repoUsuario.save(usuario);
    }
public void eliminarUsuario(Long id) {
        Usuario usuario = repoUsuario.getReferenceById(id);
        repoUsuario.delete(usuario);
}
}
