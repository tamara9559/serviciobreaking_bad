package parcial2.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parcial2.model.Capitulo;
import parcial2.model.Temporada;

import java.util.List;

public interface RepoCapitulo extends JpaRepository<Capitulo, Long> {
    @Query(value = "SELECT c FROM Capitulo c ORDER BY c.calificacion DESC")
    List<Capitulo> findTopByOrderByCalificacionDesc(Pageable pageable);

    List<Capitulo> findByTemporada(Temporada temporada); // Método para obtener los caps por temp

}









