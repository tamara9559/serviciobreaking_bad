package parcial2.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parcial2.model.Capitulo;
import parcial2.model.Temporada;

import java.util.List;

/**
 * Repositorio para la entidad Capitulo que permite realizar operaciones CRUD y consultas personalizadas.
 */
public interface RepoCapitulo extends JpaRepository<Capitulo, Long> {

    /**
     * Consulta personalizada para obtener los capítulos ordenados por calificación en orden descendente.
     *
     * @param pageable Información de paginación.
     * @return Lista de capítulos ordenados por calificación.
     */
    @Query(value = "SELECT c FROM Capitulo c ORDER BY c.calificacion DESC")
    List<Capitulo> findTopByOrderByCalificacionDesc(Pageable pageable);

    /**
     * Método para obtener los capítulos que pertenecen a una temporada específica.
     *
     * @param temporada Temporada de la cual se desean obtener los capítulos.
     * @return Lista de capítulos de la temporada especificada.
     */
    List<Capitulo> findByTemporada(Temporada temporada); // Método para obtener los capítulos por temporada
}










