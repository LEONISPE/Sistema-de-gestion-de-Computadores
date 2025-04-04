package tcc_analisi_diseno_software.Service;

import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.Model.Entities.Computador;
import tcc_analisi_diseno_software.Model.Entities.Historial_de_uso;
import tcc_analisi_diseno_software.Model.Repository.RepoHistorialUso;
import tcc_analisi_diseno_software.Model.Repository.RepoPc;

import java.util.List;

@Service
public class HistorialUsoService {


    public final RepoHistorialUso repoHistorialUso;
    public final RepoPc repoPc;

    public HistorialUsoService(RepoHistorialUso repoHistorialUso, RepoPc repoPc) {
        this.repoHistorialUso = repoHistorialUso;
        this.repoPc = repoPc;
    }

    public List<Historial_de_uso> getHistorialUsobyComputador(Long idComputador) {
        return repoHistorialUso.findBycomputador_id(idComputador);
    }

    public Historial_de_uso guardarHistorialUsoById(Long computador_id) {
        Computador computador = repoPc.findById(computador_id)
                .orElseThrow(() -> new RuntimeException("Computador no encontrado"));

        Historial_de_uso historialUso = new Historial_de_uso();
        historialUso.setComputador(computador);

        // Guardamos y retornamos el historial de uso
        return repoHistorialUso.save(historialUso);
    }


}
