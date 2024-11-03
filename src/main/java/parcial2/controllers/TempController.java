package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import parcial2.model.Capitulo;
import parcial2.model.Temporada;
import parcial2.repository.RepoCapitulo;
import parcial2.repository.RepoTemporada;

import java.util.List;

/**
 * Controlador para manejar operaciones relacionadas con Temporadas y Capítulos.
 */
@Controller
public class TempController {

    @Autowired
    private RepoTemporada repoTemporada;

    @Autowired
    private RepoCapitulo repoCapitulo;

    /**
     * Constructor que inyecta el repositorio de Temporada.
     * @param repoTemporada Repositorio de temporadas.
     */
    public TempController(RepoTemporada repoTemporada) {
        this.repoTemporada = repoTemporada;
    }

    /**
     * Devuelve una lista de todas las temporadas.
     * @return Lista de temporadas.
     */
    @GetMapping("/temporadas")
    public List<Temporada> listarTodasLasTemporadas() {
        return repoTemporada.findAll();
    }

    /**
     * Lista todas las temporadas y las añade al modelo para mostrarlas en la vista.
     * @param model Modelo que contiene la lista de temporadas.
     * @return Nombre de la vista para listar temporadas.
     */
    @GetMapping("/temporada")
    public String listarTemporadas(Model model) {
        List<Temporada> temporadas = repoTemporada.findAll();
        model.addAttribute("temporadas", temporadas);
        return "temporada";
    }

    /**
     * Lista los capítulos con mayor calificación y los añade al modelo.
     * @param model Modelo que contiene la lista de capítulos.
     * @return Nombre de la vista para listar capítulos por calificación.
     */
    @GetMapping("/capitulos/top")
    public String listarCapitulosPorCalificacion(Model model) {
        List<Capitulo> topCapitulos = repoCapitulo.findTopByOrderByCalificacionDesc(PageRequest.of(0, 5));
        model.addAttribute("capitulos", topCapitulos);
        return "capitulosTop";
    }

    /**
     * Lista los capítulos de una temporada específica.
     * @param id ID de la temporada.
     * @param model Modelo que contiene la temporada y sus capítulos.
     * @return Nombre de la vista para mostrar capítulos por temporada.
     */
    @GetMapping("/temporadas/{id}/capitulos")
    public String listarCapitulosPorTemporada(@PathVariable int id, Model model) {
        Temporada temporada = repoTemporada.findById(id).orElse(null);
        if (temporada != null) {
            List<Capitulo> capitulos = repoCapitulo.findByTemporada(temporada);
            model.addAttribute("temporada", temporada);
            model.addAttribute("capitulos", capitulos);
        } else {
            model.addAttribute("error", "Temporada no encontrada.");
        }
        return "capsxtemp"; // Vista para mostrar capítulos
    }

    /**
     * Agrega un nuevo capítulo a una temporada específica.
     * @param id ID de la temporada.
     * @param nombre Nombre del capítulo.
     * @param codigo Código del capítulo.
     * @param descripcion Descripción del capítulo.
     * @param calificacion Calificación del capítulo.
     * @return Redirección a la lista de capítulos de la temporada.
     */
    @PostMapping("/temporadas/{id}/capitulos/agregar")
    public String agregarCapitulo(@PathVariable int id, @RequestParam String nombre,
                                  @RequestParam String codigo, @RequestParam String descripcion,
                                  @RequestParam double calificacion) {
        Temporada temporada = repoTemporada.findById(id).orElse(null);
        if (temporada != null) {
            Capitulo nuevoCapitulo = new Capitulo();
            nuevoCapitulo.setNombre(nombre);
            nuevoCapitulo.setCodigo(codigo);
            nuevoCapitulo.setDescripcion(descripcion);
            nuevoCapitulo.setCalificacion(calificacion);
            nuevoCapitulo.setTemporada(temporada);
            repoCapitulo.save(nuevoCapitulo); // Guardar el nuevo capítulo
        }
        return "redirect:/temporadas/" + id + "/capitulos"; // Redirigir después de agregar
    }

    /**
     * Controlador REST para manejar operaciones relacionadas con temporadas.
     * Responde a solicitudes HTTP en la ruta "/api/temporadas".
     */
    @RestController
    @RequestMapping("/api/temporadas")
    public class TemporadaController {

        private final RepoTemporada repoTemporada;

        /**
         * Constructor que inyecta el repositorio de Temporada.
         * @param repoTemporada Repositorio de temporadas.
         */
        public TemporadaController(RepoTemporada repoTemporada) {
            this.repoTemporada = repoTemporada;
        }

        /**
         * Devuelve una lista de todas las temporadas en formato JSON.
         * @return Lista de temporadas.
         */
        @GetMapping
        public List<Temporada> listarTemporadas() {
            return repoTemporada.findAll();
        }
    }
}


