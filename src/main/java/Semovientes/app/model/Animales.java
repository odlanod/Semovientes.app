package Semovientes.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_animal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="finca_id")
    private Fincas finca;

    @Column(name="nombre_animal", nullable=true, length=40)
    private String nombre;

    @Column(name="especie_animal", nullable=false, length=30)
    private String especie;

    @Column(name="raza_animal", nullable=false, length=30)
    private String raza;

    @Column(name="sexo_animal", nullable=false, length=20)
    private String sexo;

    @Column(name="tipo_adquisicion", nullable=false, length=30)
    private String adquisicion;

    @Column(name="fecha", nullable=false)
    private LocalDate fecha;

    @Column(name="peso_inicial", nullable=false)
    private double pesoInicial;

    @Column(name="estado_animal", nullable=false, length=30)
    private String estadoAnimal;

    @ManyToOne
    @JoinColumn(name="id_madre", nullable=true)
    private Animales madre;

    @ManyToOne
    @JoinColumn(name="id_padre", nullable=true)
    private Animales padre;

    @OneToMany(mappedBy="animal")
    private List<Registro_Vacunas> registroVacunas = new ArrayList<>();

    @OneToMany(mappedBy="animal")
    public List<Registro_Animales> registroAnimales= new ArrayList<>();

    public Animales() {}

    public Animales(Fincas finca, String nombre, String especie, String raza, String sexo, String adquisicion, LocalDate fecha, double pesoInicial, String estadoAnimal) {
        this.finca = finca;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.adquisicion = adquisicion;
        this.fecha = fecha;
        this.pesoInicial = pesoInicial;
        this.estadoAnimal = estadoAnimal;
    }

    // Getters y Setters
    public Long getId_animal() { return id_animal; }
    public void setId_animal(Long id_animal) { this.id_animal = id_animal; }

    public Fincas getFinca() { return finca; }
    public void setFinca(Fincas finca) { this.finca = finca; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getAdquisicion() { return adquisicion; }
    public void setAdquisicion(String adquisicion) { this.adquisicion = adquisicion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public double getPesoInicial() { return pesoInicial; }
    public void setPesoInicial(double pesoInicial) { this.pesoInicial = pesoInicial; }

    public String getEstadoAnimal() { return estadoAnimal; }
    public void setEstadoAnimal(String estadoAnimal) { this.estadoAnimal = estadoAnimal; }

    public Animales getMadre() { return madre; }
    public void setMadre(Animales madre) { this.madre = madre; }

    public Animales getPadre() { return padre; }
    public void setPadre(Animales padre) { this.padre = padre; }

    public List<Registro_Vacunas> getRegistroVacunas() { return registroVacunas; }

    public List<Registro_Animales> getRegistroAnimales(){return registroAnimales;}
}
