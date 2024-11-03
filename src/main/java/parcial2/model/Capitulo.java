package parcial2.model;


import jakarta.persistence.*;

@Entity
public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String codigo;
    private String descripcion;
    private double calificacion;

    @ManyToOne
    @JoinColumn(name = "temporada_id")  // Clave foránea en la tabla capitulo
    private Temporada temporada;

    private String imagenes;

    public Capitulo() {
    }

    public Capitulo(String nombre, String codigo, String descripcion, double calificacion, Temporada temporada, String imagenes) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.temporada = temporada;
        this.imagenes = imagenes;
    }

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
