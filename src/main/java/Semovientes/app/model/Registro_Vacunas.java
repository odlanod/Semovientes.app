package Semovientes.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Registro_Vacunas")
public class Registro_Vacunas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animales animal;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="vacuna_id")
    private Vacunas vacuna;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario aplicador;

    @Column(name="Lote_Vacuna", nullable=true, length=40)
    private String lote_Vacuna;

    @Column(name="Dosis", nullable=false)
    private bigDecimal dosis;

    @Column(name="tipoDeDosis", nullable false, length=20)
    private String tipoDosis; 

    @Column(name="Fecha_Aplicacion", nullable=false)
    private LocalDate fecha_Vacuna;

    @Column(name="Via_Administracion", nullable=false, length=30)
    private String via_administracion;

    public Registro_Vacunas() {}

    public Registro_Vacunas(String lote_Vacuna, int dosis, String tipoDosis, LocalDate fecha_Vacuna, String via_administracion) {
        this.lote_Vacuna = lote_Vacuna;
        this.dosis = dosis;
        this.tipoDosis = tipoDosis;
        this.fecha_Vacuna = fecha_Vacuna;
        this.via_administracion = via_administracion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Animales getAnimal() { return animal; }
    public void setAnimal(Animales animal) { this.animal = animal; }

    public Vacunas getVacuna() { return vacuna; }
    public void setVacuna(Vacunas vacuna) { this.vacuna = vacuna; }

    public Usuario getAplicador() { return aplicador; }
    public void setAplicador(Usuario aplicador) { this.aplicador = aplicador; }

    public String getLote_Vacuna() { return lote_Vacuna; }
    public void setLote_Vacuna(String lote_Vacuna) { this.lote_Vacuna = lote_Vacuna; }

    public int getDosis() { return dosis; }
    public void setDosis(int dosis) { this.dosis = dosis; }

    public String getTipoDosis() { return tipoDosis; }
    public void setTipoDosis(String tipoDosis) { this.tipoDosis= tipoDosis; }

    public LocalDate getFecha_Vacuna() { return fecha_Vacuna; }
    public void setFecha_Vacuna(LocalDate fecha_Vacuna) { this.fecha_Vacuna = fecha_Vacuna; }

    public String getVia_administracion() { return via_administracion; }
    public void setVia_administracion(String via_administracion) { this.via_administracion = via_administracion; }
}
