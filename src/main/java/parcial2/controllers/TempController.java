package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import parcial2.model.Capitulo;
import parcial2.model.Temporada;
import parcial2.repository.RepoCapitulo;
import parcial2.repository.RepoTemporada;

import java.util.List;

@Controller
public class TempController {

    @Autowired
    private RepoTemporada repoTemporada;

    @Autowired
    private RepoCapitulo repoCapitulo;


    public TempController(RepoTemporada repoTemporada) {
        this.repoTemporada = repoTemporada;
    }

    @GetMapping
    public List<Temporada> listarTemporadas() {
        return repoTemporada.findAll();
    }

    @GetMapping("/temporadas")
    public String listarTemporadas(Model model) {
        List<Temporada> temporadas = repoTemporada.findAll();
        model.addAttribute("temporadas", temporadas);
        return "temporadas";
    }

    @GetMapping("/capitulos/top")
    public String listarCapitulosPorCalificacion(Model model) {
        List<Capitulo> topCapitulos = repoCapitulo.findTopByOrderByCalificacionDesc(PageRequest.of(0, 5));
        model.addAttribute("capitulos", topCapitulos);
        return "capitulosTop";
    }

    // Listar capítulos por temporada
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

    // Agregar un nuevo capítulo
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
}

