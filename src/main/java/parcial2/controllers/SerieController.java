package parcial2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST que proporciona información general sobre la serie.
 * Responde a solicitudes HTTP en la ruta "/api/serie".
 */
@RestController
@RequestMapping("/api/serie")
public class SerieController {

    /**
     * Maneja las solicitudes GET a "/api/serie/informacion".
     * Retorna un mapa con información general de la serie "Breaking Bad".
     *
     * @return Un mapa que contiene los detalles de la serie, como el nombre,
     *         descripción, creador, ruta del póster, clasificación, y promedio de calificación.
     */
    @GetMapping("/informacion")
    public Map<String, Object> getSerieInfo() {
        Map<String, Object> serieInfo = new HashMap<>();

        // Agrega datos de la serie "Breaking Bad" directamente en el mapa
        serieInfo.put("nombre", "Breaking Bad");
        serieInfo.put("descripcion", "Un profesor de química diagnosticado con cáncer de pulmón se convierte en fabricante de metanfetaminas.");
        serieInfo.put("creador", "Vince Gilligan");
        serieInfo.put("poster", "ruta/poster-breaking-bad.jpg"); // Ruta de la imagen del póster
        serieInfo.put("clasificacion", "TV-MA"); // Clasificación de edad
        serieInfo.put("promedioCalificacion", 4.9); // Calificación promedio de la serie

        return serieInfo;
    }
}


