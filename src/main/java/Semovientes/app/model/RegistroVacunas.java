package Semovientes.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="RegistroVacunas")
public class RegistroVacunas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animales animal;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="vacunaId")
    private Vacunas vacuna;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="usuarioId")
    private Usuario aplicador;

    @Column(name="loteVacuna", nullable=true, length=40)
    private String loteVacuna;

    @Column(name="Dosis", nullable=false)
    private double dosis;

    @Column(name="tipoDeDosis", nullable= false, length=20)
    private String tipoDosis; 

    @Column(name="fechaAplicacion", nullable=false)
    private LocalDate fechaVacuna;

    @Column(name="viaAdministracion", nullable=false, length=30)
    private String viaAdministracion;

    public RegistroVacunas() {}

    public RegistroVacunas(String loteVacuna, double dosis, String tipoDosis, LocalDate fechaVacuna, String viaAdministracion) {
        this.loteVacuna = loteVacuna;
        this.dosis = dosis;
        this.tipoDosis = tipoDosis;
        this.fechaVacuna = fechaVacuna;
        this.viaAdministracion = viaAdministracion;
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

    public String getLoteVacuna() { return loteVacuna; }
    public void setLoteVacuna(String loteVacuna) { this.loteVacuna = loteVacuna; }

    public double getDosis() { return dosis; }
    public void setDosis(double dosis) { this.dosis = dosis; }

    public String getTipoDosis() { return tipoDosis; }
    public void setTipoDosis(String tipoDosis) { this.tipoDosis= tipoDosis; }

    public LocalDate getFechaVacuna() { return fechaVacuna; }
    public void setFechaVacuna(LocalDate fechaVacuna) { this.fechaVacuna = fechaVacuna; }

    public String getViaAdministracion() { return viaAdministracion; }
    public void setViaAdministracion(String viaAdministracion) { this.viaAdministracion = viaAdministracion; }
}
