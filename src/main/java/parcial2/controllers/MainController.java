package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import parcial2.repository.RepoCapitulo;
import parcial2.repository.RepoTemporada;

/**
 * Controlador principal de la aplicación que gestiona la carga de datos generales y
 * la información del pie de página en todas las vistas.
 */
@Controller
public class MainController {

    @Autowired
    private RepoTemporada temporadaRepository;

    @Autowired
    private RepoCapitulo capituloRepository;

    // Valores configurados en el archivo application.properties
    @Value("${estudiante.nombre}")
    private String nombreEstudiante;

    @Value("${fecha.creacion}")
    private String fechaCreacion;

    @Value("${descripcion.ejercicio}")
    private String descripcionEjercicio;

    /**
     * Agrega información de pie de página a todas las vistas usando el modelo.
     * La información incluye el nombre del estudiante, la fecha de creación y la descripción del ejercicio.
     *
     * @param model El modelo de Spring MVC que permite añadir datos accesibles en todas las vistas.
     */
    @ModelAttribute
    public void agregarDatosPieDePagina(Model model) {
        model.addAttribute("nombreEstudiante", nombreEstudiante);
        model.addAttribute("fechaCreacion", fechaCreacion);
        model.addAttribute("descripcionEjercicio", descripcionEjercicio);
    }

    /**
     * Agrega información general sobre la serie a todas las vistas.
     * Incluye el nombre de la serie, el número total de temporadas y capítulos.
     *
     * @param model El modelo de Spring MVC que permite añadir datos accesibles en todas las vistas.
     */
    @ModelAttribute
    public void agregarDatosSerie(Model model) {
        String nombreSerie = "breaking bad"; // Nombre fijo de la serie
        int numTemporadas = (int) temporadaRepository.count(); // Número total de temporadas
        int numCapitulos = (int) capituloRepository.count(); // Número total de capítulos

        model.addAttribute("nombreSerie", nombreSerie);
        model.addAttribute("numTemporadas", numTemporadas);
        model.addAttribute("numCapitulos", numCapitulos);
    }

    /**
     * Maneja la solicitud para la página principal de la aplicación.
     *
     * @return El nombre de la vista "index" que muestra la página principal.
     */
    @RequestMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index";
    }
}
