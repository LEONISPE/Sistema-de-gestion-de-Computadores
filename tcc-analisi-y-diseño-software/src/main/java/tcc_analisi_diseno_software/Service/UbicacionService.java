package tcc_analisi_diseno_software.Service;

import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.Model.Entities.Ubicacion;
import tcc_analisi_diseno_software.Model.Repository.RepoUbicacion;

import java.util.List;

@Service
public class UbicacionService {

    private final RepoUbicacion repoUbicacion;

    public UbicacionService(RepoUbicacion repoUbicacion) {
        this.repoUbicacion = repoUbicacion;
    }


    public List<Ubicacion> getUbicacion() {
        return repoUbicacion.findAll();
    }

    public Ubicacion getUbicacionbyId(Long id) {
        return repoUbicacion.findById(id).get();
    }

    public Ubicacion addUbicacion(Ubicacion ubicacion) {
        return repoUbicacion.save(ubicacion);
    }

    public Ubicacion updateUbicacion(Ubicacion ubicacion) {
        return repoUbicacion.save(ubicacion);
    }
    public void desactivarUbicacion(Long id) {
         Ubicacion ubicacion = repoUbicacion.findById(id).get();
         ubicacion.desactivarUbicacion();
         repoUbicacion.save(ubicacion);

    }

    public void activarUbicacion(Long id) {
        Ubicacion ubicacion = repoUbicacion.findById(id).get();
        if(ubicacion.isActivo()){
            throw new RuntimeException("la ubicacion esta activada");
        }
        ubicacion.activarUbicacion();
        repoUbicacion.save(ubicacion);
    }
    public void deleteUbicacion(Long id) {
        Ubicacion ubicacion = repoUbicacion.findById(id).get();
        repoUbicacion.delete(ubicacion);
    }

}
