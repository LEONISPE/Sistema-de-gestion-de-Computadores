package tcc_analisi_diseno_software.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc_analisi_diseno_software.Model.Entities.Ubicacion;

import java.util.Optional;

public interface RepoUbicacion extends JpaRepository<Ubicacion, Long> {
    Optional<Ubicacion> findByActivo(boolean activo);

}
