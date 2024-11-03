package parcial2.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
    private String personaje;
    private String foto;

    @ManyToMany
    @JoinTable(
            name = "actor_temporada",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "temporada_id")
    )
    private List<Temporada> temporadas; // Relación con las temporadas en las que aparece

    public Actor() {
    }



    public Actor(String nombre, String descripcion, String personaje, String foto, List<Temporada> temporadas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.personaje = personaje;
        this.foto = foto;
        this.temporadas = temporadas;
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

