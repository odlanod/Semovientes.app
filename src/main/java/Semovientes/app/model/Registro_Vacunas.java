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
    private String Lote_Vacuna;

    @Column(name="Fecha_Aplicacion", nullable= false, length=10)
    private int dosis;

    @Column(name="Fecha_Aplicacion", nullable=false, length=30)
    private LocalDate fecha_Vacuna;

    @Column(name="Via_Administracion", nullable=false, length=30)
    private String via_administracion;

    public Registro_Vacunas(){}

    public Registro_Vacunas(Long id, Animales animal, Vacunas vacuna, Usuario aplicador, String lote_Vacuna, int dosis, LocalDate fecha_Vacuna, String via_administracion) {
        this.id = id;
        this.animal = animal;
        this.vacuna = vacuna;
        this.aplicador = aplicador;
        Lote_Vacuna = lote_Vacuna;
        this.dosis = dosis;
        this.fecha_Vacuna = fecha_Vacuna;
        this.via_administracion = via_administracion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animales getAnimal() {
        return animal;
    }

    public void setAnimal(Animales animal) {
        this.animal = animal;
    }

    public Vacunas getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacunas vacuna) {
        this.vacuna = vacuna;
    }

    public Usuario getAplicador() {
        return aplicador;
    }

    public void setAplicador(Usuario aplicador) {
        this.aplicador = aplicador;
    }

    public String getLote_Vacuna() {
        return Lote_Vacuna;
    }

    public void setLote_Vacuna(String lote_Vacuna) {
        Lote_Vacuna = lote_Vacuna;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public LocalDate getFecha_Vacuna() {
        return fecha_Vacuna;
    }

    public void setFecha_Vacuna(LocalDate fecha_Vacuna) {
        this.fecha_Vacuna = fecha_Vacuna;
    }

    public String getVia_administracion() {
        return via_administracion;
    }

    public void setVia_administracion(String via_administracion) {
        this.via_administracion = via_administracion;
    }
}
