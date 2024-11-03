package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import parcial2.model.Capitulo;
import parcial2.repository.RepoCapitulo;
import parcial2.service.ServiceCap;

/**
 * Controlador principal para manejar las solicitudes relacionadas con capítulos en la aplicación.
 */
@Controller
public class CapController {

    private final ServiceCap serviceCap;

    @Autowired
    private RepoCapitulo repoCapitulo;

    /**
     * Constructor del controlador CapController que permite la inyección del servicio ServiceCap.
     *
     * @param serviceCap Servicio de capítulos que proporciona lógica de negocio relacionada con capítulos.
     */
    @Autowired
    public CapController(ServiceCap serviceCap) {
        this.serviceCap = serviceCap;
    }

    /**
     * Método para la página de inicio que muestra el capítulo mejor calificado.
     *
     * @param model Modelo de Spring MVC que contiene los datos a pasar a la vista.
     * @return      El nombre de la vista "index" donde se muestra el capítulo con mejor calificación.
     */
    @GetMapping("/index")
    public String index(Model model) {
        Capitulo capitulo = serviceCap.getCapMejor();
        model.addAttribute("capitulo", capitulo);
        return "index";
    }

    /**
     * Método para mostrar los detalles de un capítulo específico.
     *
     * @param id    ID del capítulo a mostrar.
     * @param model Modelo de Spring MVC para pasar datos a la vista Thymeleaf.
     * @return      Nombre de la vista "detallesCapitulo" que muestra los detalles del capítulo.
     */
    @GetMapping("/capitulos/{id}/detalles")
    public String mostrarDetallesCapitulo(@PathVariable Long id, Model model) {
        Capitulo capitulo = repoCapitulo.findById(id).orElse(null);

        if (capitulo != null) {
            // Si el capítulo existe, se pasa a la vista el objeto capítulo y el arreglo de imágenes.
            model.addAttribute("capitulo", capitulo);
            String[] imagenesArray = capitulo.getImagenes() != null ? capitulo.getImagenes().split(",") : new String[0];
            model.addAttribute("imagenes", imagenesArray);
        } else {
            // Si no se encuentra el capítulo, se envía un mensaje de error a la vista.
            model.addAttribute("error", "Capítulo no encontrado.");
        }

        return "detallesCapitulo"; // Nombre de la vista para mostrar detalles del capítulo
    }
}

