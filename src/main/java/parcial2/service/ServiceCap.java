package parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import parcial2.excepciones.CapNotFoundException;
import parcial2.model.Capitulo;
import parcial2.repository.RepoCapitulo;

/**
 * Servicio para manejar la lógica relacionada con los capítulos.
 */
@Service
public class ServiceCap {
    private final RepoCapitulo RepoCap;

    /**
     * Constructor para inyectar el repositorio de capítulos.
     *
     * @param RepoCap Repositorio para operaciones de capítulos.
     */
    @Autowired
    public ServiceCap(RepoCapitulo RepoCap) {
        this.RepoCap = RepoCap;
    }

    /**
     * Obtiene el capítulo mejor calificado.
     *
     * @return El capítulo con la mejor calificación.
     * @throws CapNotFoundException Si no hay capítulos disponibles.
     */
    public Capitulo getCapMejor() {
        return RepoCap.findTopByOrderByCalificacionDesc(PageRequest.of(0, 1)).stream()
                .findFirst()
                .orElseThrow(() -> new CapNotFoundException("No hay capítulos disponibles"));
    }
}

