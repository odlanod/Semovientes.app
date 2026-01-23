package Semovientes.app.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="fincas")
public class Finca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propietario_id", nullable = false)
    private Usuario usuario;

    @Column(name="nombre_finca", nullable=false, length=50)
    private String nombre;

    @Column(name="descripcion_finca", nullable=false, length=100)
    private String descripcion;

    @Column(name="numero_hectareas", nullable=false)
    private double hectareas;

    @Column(name="liberaciones", nullable=false)
    private double liberaciones;

    @OneToMany(mappedBy = "finca", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Animal> animales = new ArrayList<>();

    public Finca() {}

    public Finca(Usuario usuario, String nombre, String descripcion, double hectareas, double liberaciones) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hectareas = hectareas;
        this.liberaciones = liberaciones;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getHectareas() { return hectareas; }
    public void setHectareas(double hectareas) { this.hectareas = hectareas; }

    public double getLiberaciones() { return liberaciones; }
    public void setLiberaciones(double liberaciones) { this.liberaciones = liberaciones; }
}
