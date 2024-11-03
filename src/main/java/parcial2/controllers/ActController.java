package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcial2.model.Actor;
import parcial2.repository.RepoActor;

import java.util.List;

/**
 * Controlador principal para manejar solicitudes relacionadas con los actores en la aplicación.
 */
@Controller
public class ActController {

    @Autowired
    private RepoActor repoActor;

    /**
     * Constructor del controlador ActController que permite la inyección de la dependencia RepoActor.
     *
     * @param repoActor Repositorio de actores que proporciona métodos para interactuar con la base de datos.
     */
    public ActController(RepoActor repoActor) {
        this.repoActor = repoActor;
    }

    /**
     * Método para listar todos los actores.
     *
     * @return Una lista de todos los actores en la base de datos.
     */
    @GetMapping("/personajes")
    public List<Actor> listarPersonajes() {
        return repoActor.findAll();
    }

    /**
     * Método para obtener los actores de una temporada específica.
     *
     * @param id    ID de la temporada para la cual se quieren obtener los actores.
     * @param model Modelo de Spring MVC para pasar datos a la vista Thymeleaf.
     * @return      El nombre de la vista Thymeleaf "actores", donde se muestran los actores.
     */
    @GetMapping("/temporada/{id}/actoresT")
    public String obtenerActoresPorTemporada(@PathVariable int id, Model model) {
        List<Actor> actores = repoActor.findActorsByTemporada((long) id);
        model.addAttribute("actores", actores);
        return "actores"; // Nombre de la vista Thymeleaf
    }

    /**
     * Controlador interno REST para manejar solicitudes de la API relacionadas con los actores.
     *
     * Este controlador proporciona un punto de acceso a la API para interactuar con la lista
     * de actores, y es útil para consumir datos desde clientes externos o servicios web.
     */
    @RestController
    @RequestMapping("/api/personajes")
    public class ActorController {

        private final RepoActor repoActor;

        /**
         * Constructor del controlador REST ActorController que permite la inyección de la dependencia RepoActor.
         *
         * @param repoActor Repositorio de actores que proporciona métodos para interactuar con la base de datos.
         */
        public ActorController(RepoActor repoActor) {
            this.repoActor = repoActor;
        }

        /**
         * Endpoint de la API REST para listar todos los actores.
         *
         * @return Una lista de todos los actores en la base de datos.
         */
        @GetMapping
        public List<Actor> listarPersonajes() {
            return repoActor.findAll();
        }
    }
}


