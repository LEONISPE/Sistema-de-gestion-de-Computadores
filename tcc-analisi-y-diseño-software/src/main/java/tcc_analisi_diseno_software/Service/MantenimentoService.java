package tcc_analisi_diseno_software.Service;

import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.DTO.MantenimientoDTO;
import tcc_analisi_diseno_software.DTO.PCDTO;
import tcc_analisi_diseno_software.Model.Entities.Computador;
import tcc_analisi_diseno_software.Model.Entities.Mantenimiento;
import tcc_analisi_diseno_software.Model.Repository.RepoMantenimiento;
import tcc_analisi_diseno_software.Model.Repository.RepoPc;

import java.time.LocalDate;
import java.util.List;

@Service
public class MantenimentoService {

    private final RepoMantenimiento repoMantenimiento;
    private final RepoPc repoPc;

    public MantenimentoService(RepoMantenimiento repoMantenimiento, RepoPc repoPc) {
        this.repoMantenimiento = repoMantenimiento;
        this.repoPc = repoPc;
    }


    public List<MantenimientoDTO> getMantenimientoByComputadorId(Long computador_id) {
        List<Mantenimiento> mantenimientos = repoMantenimiento.findBycomputador_id(computador_id);

        return mantenimientos.stream()
                .map(mantenimiento -> new MantenimientoDTO(
                        mantenimiento.getId(),
                        mantenimiento.getComputador(),
                        mantenimiento.getDescripcion_mantenimiento(),
                        mantenimiento.getFecha_mantenimiento(),
                        mantenimiento.getResponsable(),
                        mantenimiento.getFecha_programada()
                )).toList();
    }

    public void addMantenimiento(MantenimientoDTO mantenimientoDTO, Long computador_id) {
        Computador computador = repoPc.findById(computador_id)
                .orElseThrow(() -> new RuntimeException("Computador not found"));
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setComputador(mantenimientoDTO.getComputador());
        mantenimiento.setDescripcion_mantenimiento(mantenimientoDTO.getDescripcion_mantenimiento());
        mantenimiento.setFecha_mantenimiento(mantenimientoDTO.getFecha_mantenimiento());
        mantenimiento.setResponsable(mantenimientoDTO.getResponsable());
        repoMantenimiento.save(mantenimiento);
    }

    public void updateMantenimiento(MantenimientoDTO mantenimientoDTO, Long computador_id) {
        // Buscar el computador asociado
        Computador computador = repoPc.findById(computador_id)
                .orElseThrow(() -> new RuntimeException("Computador no encontrado"));

        // Buscar el mantenimiento a actualizar
        Mantenimiento mantenimientoExistente = repoMantenimiento.findById(mantenimientoDTO.getId()) // Debes asegurarte de que el DTO tenga el ID del mantenimiento
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));

        // Actualización de los valores del mantenimiento
        mantenimientoExistente.setComputador(computador);
        mantenimientoExistente.setDescripcion_mantenimiento(mantenimientoDTO.getDescripcion_mantenimiento());
        mantenimientoExistente.setFecha_mantenimiento(mantenimientoDTO.getFecha_mantenimiento());
        mantenimientoExistente.setResponsable(mantenimientoDTO.getResponsable());

        // Guardar los cambios
        repoMantenimiento.save(mantenimientoExistente);


    }

    public MantenimientoDTO programarMantenimiento(MantenimientoDTO mantenimientoDTO, Long computador_id) {
        // Obtener el computador correspondiente
        Computador computador = repoPc.findById(computador_id)
                .orElseThrow(() -> new RuntimeException("Computador not found"));

        // Validar que la fecha programada esté en el futuro
        if (mantenimientoDTO.getFecha_programada().isBefore(LocalDate.now())) {
            throw new RuntimeException("Fecha programada debe ser en el futuro");
        }

        // Crear un nuevo objeto Mantenimiento a partir del DTO
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setComputador(computador);
        mantenimiento.setDescripcion_mantenimiento(mantenimientoDTO.getDescripcion_mantenimiento());
        mantenimiento.setFecha_mantenimiento(mantenimientoDTO.getFecha_mantenimiento());
        mantenimiento.setResponsable(mantenimientoDTO.getResponsable());
        mantenimiento.setFecha_programada(mantenimientoDTO.getFecha_programada());
        mantenimiento.setProgramado(true); // Si está programado, lo marcamos como verdadero

        // Guardar el mantenimiento en la base de datos
        Mantenimiento mantenimientoGuardado = repoMantenimiento.save(mantenimiento);

        // Convertir la entidad Mantenimiento guardada de nuevo a un DTO para devolverlo
        return new MantenimientoDTO(
                mantenimientoGuardado.getId(),
                mantenimientoGuardado.getComputador(),
                mantenimientoGuardado.getDescripcion_mantenimiento(),
                mantenimientoGuardado.getFecha_mantenimiento(),
                mantenimientoGuardado.getResponsable(),
                mantenimientoGuardado.getFecha_programada()
        );
    }
}

