package Semovientes.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="finca_id")
    private Fincas finca;

    @Column(name="nombreAnimal", length=40)
    private String nombre;

    @Column(name="especieAnimal", nullable = false, length=30)
    private String especie;

    @Column(name="razaAnimal", nullable = false, length=30)
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
    @JoinColumn(name="id_madre")
    @JsonIgnoreProperties({"madre", "padre", "registroVacunas", "registroAnimales"})
    private Animal madre;

    @ManyToOne
    @JoinColumn(name="id_padre", nullable=true)
    @JsonIgnoreProperties({"madre", "padre", "registroVacunas", "registroAnimales"})
    private Animal padre;

    @OneToMany(mappedBy="animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroVacunas> registroVacunas = new ArrayList<>();

    @OneToMany(mappedBy="animal")
    private List<RegistroAnimales> registroAnimales= new ArrayList<>();

    public Animal() {}

    public Animal(Fincas finca, String nombre, String especie, String raza, String sexo, String adquisicion, LocalDate fecha, double pesoInicial, String estadoAnimal) {
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
    public Long getIdAnimal() { return idAnimal; }
    public void setIdAnimal(Long idAnimal) { this.idAnimal = idAnimal; }

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

    public Animal getMadre() { return madre; }
    public void setMadre(Animal madre) { this.madre = madre; }

    public Animal getPadre() { return padre; }
    public void setPadre(Animal padre) { this.padre = padre; }

    public List<RegistroVacunas> getRegistroVacunas() { return registroVacunas; }

    public List<RegistroAnimales> getRegistroAnimales(){return registroAnimales;}
}
