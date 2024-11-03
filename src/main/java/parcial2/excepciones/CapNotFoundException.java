package parcial2.excepciones;

/**
 * Excepción personalizada para manejar casos en los que no se encuentra un capítulo.
 */
public class CapNotFoundException extends RuntimeException {

    /**
     * Constructor que acepta un mensaje de error específico.
     *
     * @param message Mensaje que describe el error.
     */
    public CapNotFoundException(String message) {
        super(message);
    }
}

