package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import parcial2.repository.RepoCapitulo;
import parcial2.repository.RepoTemporada;

@Controller
public class MainController {

    @Autowired
    private RepoTemporada temporadaRepository;

    @Autowired
    private RepoCapitulo capituloRepository;

    @Value("${estudiante.nombre}")
    private String nombreEstudiante;

    @Value("${fecha.creacion}")
    private String fechaCreacion;

    @Value("${descripcion.ejercicio}")
    private String descripcionEjercicio;

    // Agregar información del pie de página al modelo
    @ModelAttribute
    public void agregarDatosPieDePagina(Model model) {
        model.addAttribute("nombreEstudiante", nombreEstudiante);
        model.addAttribute("fechaCreacion", fechaCreacion);
        model.addAttribute("descripcionEjercicio", descripcionEjercicio);
    }

    // Cargar información general de la serie
    @ModelAttribute
    public void agregarDatosSerie(Model model) {
        String nombreSerie = "breaking bad";
        int numTemporadas = (int) temporadaRepository.count();
        int numCapitulos = (int) capituloRepository.count();

        model.addAttribute("nombreSerie", nombreSerie);
        model.addAttribute("numTemporadas", numTemporadas);
        model.addAttribute("numCapitulos", numCapitulos);
    }

    @RequestMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index";
    }
}

