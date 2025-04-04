package tcc_analisi_diseno_software.Service;

import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.DTO.PCDTO;
import tcc_analisi_diseno_software.Model.Entities.Computador;
import tcc_analisi_diseno_software.Model.Repository.RepoPc;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PcService {

    private final RepoPc repoPc;

    public PcService(RepoPc repoPc) {
        this.repoPc = repoPc;
    }

    public List<PCDTO> getPc() {
        return repoPc.findAll()
                .stream()
                .map(Computador -> new PCDTO(
                        Computador.getId(),
                        Computador.getMarca(),
                        Computador.getModelo(),
                        Computador.getNumero_serie(),
                        Computador.getUbicacion(),
                        Computador.getFecha_adquisicion(),
                        Computador.getActivo()
                )).toList();
    }

    public PCDTO getPcById(Long id) {
        Computador computador = repoPc.findById(id).get();

        return new PCDTO(
                computador.getId(),
                computador.getMarca(),
                computador.getModelo(),
                computador.getNumero_serie(),
                computador.getUbicacion(),
                computador.getFecha_adquisicion(),
                computador.getActivo()
        );
    }

    public void savePc(PCDTO pc) {
        Computador computador = new Computador();
        computador.setMarca(pc.getMarca());
        computador.setModelo(pc.getModelo());
        computador.setNumero_serie(pc.getNumero_serie());
        computador.setUbicacion(pc.getUbicacion());
        computador.setFecha_adquisicion(pc.getFecha_adquisicion());
        computador.setActivo(pc.isActivoBoolean());
        repoPc.save(computador);
    }

    public void updatePc(Long id, PCDTO pc) {
        Computador computador = repoPc.findById(id).get();
        computador.setMarca(pc.getMarca());
        computador.setModelo(pc.getModelo());
        computador.setNumero_serie(pc.getNumero_serie());
        computador.setUbicacion(pc.getUbicacion());
        computador.setFecha_adquisicion(pc.getFecha_adquisicion());
        repoPc.save(computador);


    }

    public void desactivarPc(Long id) {
        Computador computador = repoPc.findById(id).get();
        computador.desactivarPc();
        repoPc.save(computador);

    }

    public void activarPc(Long id) {
        Computador computador = repoPc.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró un computador con ID: " + id));

        // Validar si el PC ya está activo
        if (computador.getActivo()) {
            throw new IllegalStateException("El computador con ID " + id + " ya está activo.");
        }

        computador.activarPc();
        repoPc.save(computador);
    }
}