package parcial2.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una temporada en la base de datos.
 */
@Entity
public class Temporada {

    /**
     * ID único de la temporada, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Número de la temporada.
     */
    private int temporada;

    /**
     * Fecha de estreno de la temporada.
     */
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * Número de capítulos en la temporada.
     */
    private int capitulos;

    /**
     * Lista de capítulos que pertenecen a esta temporada.
     * Relación de uno a muchos con la entidad Capitulo.
     */
    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Capitulo> capitulosList;

    /**
     * Constructor vacío para la entidad Temporada.
     */
    public Temporada() {
    }

    /**
     * Constructor completo para inicializar una Temporada.
     *
     * @param temporada Número de la temporada.
     * @param fecha Fecha de estreno de la temporada.
     * @param capitulos Número de capítulos en la temporada.
     */
    public Temporada(int temporada, Date fecha, int capitulos) {
        this.temporada = temporada;
        this.fecha = fecha;
        this.capitulos = capitulos;
    }

    // Getters y setters para los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(int capitulos) {
        this.capitulos = capitulos;
    }
}
