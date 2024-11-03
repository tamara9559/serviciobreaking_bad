package parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import parcial2.model.Actor;

import java.util.List;

public interface RepoActor extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a JOIN a.temporadas t WHERE t.id = :temporadaId")
    List<Actor> findActorsByTemporada(@Param("temporadaId") Long temporadaId);
}

