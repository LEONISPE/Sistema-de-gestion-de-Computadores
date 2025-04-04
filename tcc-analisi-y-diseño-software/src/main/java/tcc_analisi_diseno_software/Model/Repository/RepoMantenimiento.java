package tcc_analisi_diseno_software.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc_analisi_diseno_software.Model.Entities.Mantenimiento;

import java.util.List;

public interface RepoMantenimiento extends JpaRepository<Mantenimiento, Long> {
    List<Mantenimiento> findBycomputador_id(Long computador_id);
}
