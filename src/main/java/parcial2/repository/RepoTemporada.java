package parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import parcial2.model.Temporada;

/**
 * Repositorio para la entidad Temporada que permite realizar operaciones CRUD.
 */
public interface RepoTemporada extends JpaRepository<Temporada, Integer> {
    // No se requieren métodos adicionales por el momento, ya que JpaRepository proporciona las operaciones básicas.
}

