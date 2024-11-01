package parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial2.model.Temporada;

public interface RepoTemporada extends JpaRepository<Temporada, Integer> {
}

