package Semovientes.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fincas")
public class Fincas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="propietario_id")
    private Usuario usuario;
    @Column(name="nombre_finca",nullable= false,length=50)
    private String nombre;
    @Column(name="descripcion_finca",nullable= false,length=100)
    private String descripcion;
    @Column(name="numero_hectareas",nullable= false,length=20)
    private double hectareas;
    @Column(name="liberaciones",nullable= false,length=20)
    private double liberaciones;

    public Fincas(int id, Usuario usuario, String nombre, String descripcion, double hectareas, double liberaciones) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hectareas = hectareas;
        this.liberaciones = liberaciones;
    }
    public Fincas(){}

    //SETTERS ------------------------------------------------------


    public void setId(int id) {this.id = id;}

    public void setUsuario(Usuario usuario){this.usuario = usuario;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHectareas(double hectareas) {
        this.hectareas = hectareas;
    }

    public void setLiberaciones(double liberaciones) {
        this.liberaciones = liberaciones;
    }

    //GETTER ------------------------------------------------------------
    public int getId() {
        return id;
    }

    public Usuario getUsuario(){return usuario;}

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getHectareas() {
        return hectareas;
    }

    public double getLiberaciones() {
        return liberaciones;
    }
}
