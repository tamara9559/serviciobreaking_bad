package parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial2.model.Temporada;
import parcial2.repository.RepoTemporada;

import java.util.List;

/**
 * Servicio para manejar la lógica relacionada con las temporadas.
 */
@Service
public class TempService {

    @Autowired
    private RepoTemporada temporadaRepository;

    /**
     * Agrega una nueva temporada al repositorio.
     *
     * @param temporada La temporada a agregar.
     * @return La temporada guardada.
     */
    public Temporada agregarTemporada(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }

    /**
     * Lista todas las temporadas disponibles.
     *
     * @return Una lista de temporadas.
     */
    public List<Temporada> listarTemporadas() {
        return temporadaRepository.findAll();
    }
}

