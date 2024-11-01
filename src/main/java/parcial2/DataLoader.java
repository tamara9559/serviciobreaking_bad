package parcial2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import parcial2.repository.RepoTemporada;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RepoTemporada temporadaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (temporadaRepository.count() == 0) {
            System.err.println("Error: No se encontraron temporadas en la base de datos.");
        }
    }
}
