package Semovientes.app.model;

import jakarta.persistence.*;

@Entity
@Table(name="fincas")
public class Fincas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="propietario_id")
    private Usuario usuario;

    @Column(name="nombre_finca", nullable=false, length=50)
    private String nombre;

    @Column(name="descripcion_finca", nullable=false, length=100)
    private String descripcion;

    @Column(name="numero_hectareas", nullable=false)
    private double hectareas;

    @Column(name="liberaciones", nullable=false)
    private double liberaciones;

    public Fincas() {}

    public Fincas(Usuario usuario, String nombre, String descripcion, double hectareas, double liberaciones) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hectareas = hectareas;
        this.liberaciones = liberaciones;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
