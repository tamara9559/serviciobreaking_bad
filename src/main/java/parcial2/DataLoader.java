package parcial2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parcial2.repository.RepoTemporada;

/**
 * Clase que carga datos iniciales en la base de datos al iniciar la aplicación.
 */
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RepoTemporada temporadaRepository;

    /**
     * Método que se ejecuta al iniciar la aplicación.
     * Verifica si hay temporadas en la base de datos y muestra un mensaje de error si no se encuentran.
     *
     * @param args Argumentos de línea de comandos.
     * @throws Exception Excepción que puede ocurrir durante la ejecución.
     */
    @Override
    public void run(String... args) throws Exception {
        if (temporadaRepository.count() == 0) {
            System.err.println("Error: No se encontraron temporadas en la base de datos.");
        }
    }
}

