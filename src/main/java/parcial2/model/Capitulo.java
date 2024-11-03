package parcial2.model;

import jakarta.persistence.*;

/**
 * Clase que representa un capítulo en la base de datos.
 */
@Entity
public class Capitulo {

    /**
     * ID único del capítulo, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Nombre del capítulo.
     */
    private String nombre;

    /**
     * Código único del capítulo.
     */
    private String codigo;

    /**
     * Descripción del capítulo.
     */
    private String descripcion;

    /**
     * Calificación del capítulo (puntuación promedio).
     */
    private double calificacion;

    /**
     * Temporada a la que pertenece el capítulo.
     * Relación de muchos a uno con la entidad Temporada.
     */
    @ManyToOne
    @JoinColumn(name = "temporada_id")  // Clave foránea en la tabla capitulo
    private Temporada temporada;

    /**
     * URLs de imágenes del capítulo, separadas por comas.
     */
    private String imagenes;

    /**
     * Constructor vacío para la entidad Capitulo.
     */
    public Capitulo() {
    }

    /**
     * Constructor completo para inicializar un Capitulo.
     *
     * @param nombre Nombre del capítulo.
     * @param codigo Código único del capítulo.
     * @param descripcion Descripción del capítulo.
     * @param calificacion Calificación del capítulo.
     * @param temporada Temporada a la que pertenece el capítulo.
     * @param imagenes URLs de las imágenes del capítulo, separadas por comas.
     */
    public Capitulo(String nombre, String codigo, String descripcion, double calificacion, Temporada temporada, String imagenes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.temporada = temporada;
        this.imagenes = imagenes;
    }

    // Getters y setters para los atributos

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
