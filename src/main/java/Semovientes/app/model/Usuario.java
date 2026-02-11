package Semovientes.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="aplicador")
    private List<RegistroVacunas> registroVacuna = new ArrayList<>();

    @OneToMany(mappedBy="usuario")
    private List<Finca> fincas = new ArrayList<>();

    @Column(name="nombres", nullable=false, length=30)
    private String nombre;

    @Column(name="apellidos", nullable=false, length=30)
    private String apellidos;

    @Column(name="cedula_usuario", nullable=false, unique=true)
    private String cedula;

    @Column(name="correoElectronico", nullable=false, unique=true)
    private String correoElectronico;

    @Column(name="fechaNacimiento", nullable=false)
    private LocalDate fechaNacimiento;

    @Column(name="password_hash", nullable=false, length=255)
    private String password;

    @Column(name="rolUsuario", nullable=false, length=30)
    private String rol;

    @Column(name="sueldo_usuario", nullable=false)
    private double sueldo;

    @Column(name="estado", nullable=false)
    private Boolean estado;

    @Column(name="generoUsuario", nullable=false, length=50)
    private String genero;

    @OneToMany(mappedBy="usuario")
    private List<RegistroAnimales> registros= new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombre, String apellidos, String cedula, String correoElectronico, LocalDate fechaNacimiento, String password, String rol, double sueldo, Boolean estado, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.rol = rol;
        this.sueldo = sueldo;
        this.estado = estado;
        this.genero = genero;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<RegistroVacunas> getRegistroVacunas() { return registroVacuna; }
    public List<Finca> getFincas() { return fincas; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public double getSueldo() { return sueldo; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public List<RegistroAnimales> getRegistroAnimales(){return registros; }
}
