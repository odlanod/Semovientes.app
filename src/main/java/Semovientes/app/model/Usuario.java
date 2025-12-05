package Semovientes.app.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="aplicador")
    private List<Registro_Vacunas> registroVacuna= new ArrayList<>();

    @OneToMany(mappedBy="usuario")
    private List<Fincas> fincas = new ArrayList<>();

    @Column(name="nombre_Usuario",nullable = false, length=30)
    private String nombre;

    @Column(name="apellido_Usuario",nullable=false, length=30)
    private String apellidos;

    @Column(name="cedula_usuario", nullable=false,unique=true)
    private String cedula;

    @Column(name="correoElectonico", nullable=false,unique=true)
    private String correoElectonico;

    @Column(name="fecha_nacimiento", nullable=false)
    private LocalDate fecha_Nacimiento_usuario;

    @Column(name="password_hash", nullable = false, length=255)
    private String password;

    @Column(name="rol_usuario",nullable=false, length=30)
    private String rol;

    @Column(name="sueldo_usuario",nullable=false, length=50)
    private double sueldo;

    @Column(name="estado",nullable=false, length=20)
    private Boolean estado;

    @Column(name="genero_usuario",nullable=false, length=50)
    private String genero;

    public Usuario(Long id, String nombre, String apellidos, String cedula, String correoElectonico, LocalDate fecha_Nacimiento_usuario, String password, String rol, double sueldo, Boolean estado, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElectonico = correoElectonico;
        this.fecha_Nacimiento_usuario = fecha_Nacimiento_usuario;
        this.password = password;
        this.rol = rol;
        this.sueldo = sueldo;
        this.estado = estado;
        this.genero = genero;
    }

    public Usuario(){}

    public Long getId() {
        return id;
    }

    public List<Registro_Vacunas> registroVacunas(){
        return registroVacuna;
    }

    public List<Fincas> getFincas() {
        return fincas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElectonico() {
        return correoElectonico;
    }

    public void setCorreoElectonico(String correoElectonico) {
        this.correoElectonico = correoElectonico;
    }

    public LocalDate getFecha_Nacimiento_usuario() {
        return fecha_Nacimiento_usuario;
    }

    public void setFecha_Nacimiento_usuario(LocalDate fecha_Nacimiento_usuario) {
        this.fecha_Nacimiento_usuario = fecha_Nacimiento_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
