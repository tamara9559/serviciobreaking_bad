package parcial2.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int temporada;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private int capitulos;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Capitulo> capitulosList;

    public Temporada() {
    }

    public Temporada(int temporada, Date fecha, int capitulos) {
        this.temporada = temporada;
        this.fecha = fecha;
        this.capitulos = capitulos;
    }

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
