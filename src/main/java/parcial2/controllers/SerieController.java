package parcial2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/serie")
public class SerieController {

    @GetMapping("/informacion")
    public Map<String, Object> getSerieInfo() {
        Map<String, Object> serieInfo = new HashMap<>();

        // Agregar los datos de la serie directamente al Map
        serieInfo.put("nombre", "Breaking Bad");
        serieInfo.put("descripcion", "Un profesor de química diagnosticado con cáncer de pulmón se convierte en fabricante de metanfetaminas.");
        serieInfo.put("creador", "Vince Gilligan");
        serieInfo.put("poster", "ruta/poster-breaking-bad.jpg");
        serieInfo.put("clasificacion", "TV-MA");
        serieInfo.put("promedioCalificacion", 4.9);

        return serieInfo;
    }
}

