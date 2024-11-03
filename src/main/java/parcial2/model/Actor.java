package parcial2.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Clase que representa a un actor en la base de datos.
 */
@Entity
public class Actor {

    /**
     * ID único del actor, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del actor.
     */
    private String nombre;

    /**
     * Descripción del actor.
     */
    private String descripcion;

    /**
     * Nombre del personaje interpretado por el actor.
     */
    private String personaje;

    /**
     * URL de la foto del actor.
     */
    private String foto;

    /**
     * Relación de muchos a muchos con las temporadas en las que aparece el actor.
     */
    @ManyToMany
    @JoinTable(
            name = "actor_temporada",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "temporada_id")
    )
    private List<Temporada> temporadas; // Relación con las temporadas en las que aparece

    /**
     * Constructor vacío para la entidad Actor.
     */
    public Actor() {
    }

    /**
     * Constructor completo para inicializar un Actor.
     *
     * @param nombre Nombre del actor.
     * @param descripcion Descripción del actor.
     * @param personaje Nombre del personaje que interpreta.
     * @param foto URL de la foto del actor.
     * @param temporadas Lista de temporadas en las que aparece el actor.
     */
    public Actor(String nombre, String descripcion, String personaje, String foto, List<Temporada> temporadas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personaje = personaje;
        this.foto = foto;
        this.temporadas = temporadas;
    }

    // Getters y setters para los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }
}
