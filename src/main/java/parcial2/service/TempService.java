package parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parcial2.model.Temporada;
import parcial2.repository.RepoTemporada;

import java.util.List;

@Service
public class TempService {

    @Autowired
    private RepoTemporada temporadaRepository;

    public Temporada agregarTemporada(Temporada temporada) {
        return temporadaRepository.save(temporada);
    }

    public List<Temporada> listarTemporadas() {
        return temporadaRepository.findAll();
    }
}
