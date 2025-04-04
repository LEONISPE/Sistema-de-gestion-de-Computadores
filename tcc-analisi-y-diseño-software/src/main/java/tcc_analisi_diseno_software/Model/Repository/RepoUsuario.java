package tcc_analisi_diseno_software.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import tcc_analisi_diseno_software.Model.Entities.Usuario;

import java.util.Optional;

public interface RepoUsuario extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByActivo(Boolean activo);
}
