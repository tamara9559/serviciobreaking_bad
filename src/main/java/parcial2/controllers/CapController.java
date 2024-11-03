package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import parcial2.model.Capitulo;
import parcial2.repository.RepoCapitulo;
import parcial2.service.ServiceCap;

@Controller
public class CapController {

    private final ServiceCap serviceCap;

    @Autowired
    private RepoCapitulo repoCapitulo;


    @Autowired
    public CapController(ServiceCap serviceCap) {
        this.serviceCap = serviceCap;
    }

    @GetMapping("/index")
    public String index(Model model) {
        Capitulo capitulo = serviceCap.getCapMejor();
        model.addAttribute("capitulo", capitulo);
        return "index";
    }

    // Método para mostrar los detalles del capítulo
    @GetMapping("/capitulos/{id}/detalles")
    public String mostrarDetallesCapitulo(@PathVariable Long id, Model model){
        Capitulo capitulo = repoCapitulo.findById(id).orElse(null);
        if (capitulo != null) {
            model.addAttribute("capitulo", capitulo);
            String[] imagenesArray = capitulo.getImagenes() != null ? capitulo.getImagenes().split(",") : new String[0];
            model.addAttribute("imagenes", imagenesArray);
        } else {
            model.addAttribute("error", "Capítulo no encontrado.");
        }
        return "detallesCapitulo"; // Nombre de la vista para mostrar detalles
    }

}
