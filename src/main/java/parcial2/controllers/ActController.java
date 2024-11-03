package parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import parcial2.model.Actor;
import parcial2.repository.RepoActor;

import java.util.List;

@Controller
public class ActController {
    @Autowired
    private RepoActor actorRepository;

    @GetMapping("/temporada/{id}/actores")
    public String obtenerActoresPorTemporada(@PathVariable int id, Model model) {
        List<Actor> actores = actorRepository.findActorsByTemporada((long) id);
        model.addAttribute("actores", actores);
        return "actores"; // Nombre de la vista Thymeleaf
    }


}

