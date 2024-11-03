package parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parcial2.model.Actor;

import java.util.List;

/**
 * Repositorio para la entidad Actor que permite realizar operaciones CRUD y consultas personalizadas.
 */
public interface RepoActor extends JpaRepository<Actor, Long> {

    /**
     * Consulta personalizada para encontrar actores que aparecieron en una temporada específica.
     *
     * @param temporadaId ID de la temporada.
     * @return Lista de actores que aparecen en la temporada especificada.
     */
    @Query("SELECT a FROM Actor a JOIN a.temporadas t WHERE t.id = :temporadaId")
    List<Actor> findActorsByTemporada(@Param("temporadaId") Long temporadaId);
}

