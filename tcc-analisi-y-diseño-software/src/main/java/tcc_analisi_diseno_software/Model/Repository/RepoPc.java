package tcc_analisi_diseno_software.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc_analisi_diseno_software.Model.Entities.Computador;

import java.util.Optional;

public interface RepoPc extends JpaRepository<Computador,Long> {

    Optional<Computador> findByActivo(Boolean activo);
}
