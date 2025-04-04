package tcc_analisi_diseno_software.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc_analisi_diseno_software.Model.Entities.Historial_de_uso;

import java.util.List;

public interface RepoHistorialUso extends JpaRepository<Historial_de_uso, Long> {
    List<Historial_de_uso> findBycomputador_id(Long computador_id);

}
