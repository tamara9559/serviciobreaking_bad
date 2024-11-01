package parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import parcial2.excepciones.CapNotFoundException;
import parcial2.model.Capitulo;
import parcial2.repository.RepoCapitulo;

@Service
public class ServiceCap {
    private final RepoCapitulo RepoCap;

    @Autowired
    public ServiceCap(RepoCapitulo RepoCap) {
        this.RepoCap = RepoCap;
    }

    public Capitulo getCapMejor() {
        return RepoCap.findTopByOrderByCalificacionDesc(PageRequest.of(0, 1)).stream()
                .findFirst()
                .orElseThrow(() -> new CapNotFoundException("No hay capítulos disponibles"));
    }


}

