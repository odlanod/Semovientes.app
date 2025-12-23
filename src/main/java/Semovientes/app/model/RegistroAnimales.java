package Semovientes.app.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="RegistroAnimales")

public class RegistroAnimales{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="fechaRegistro", nullable=false)
private LocalDate fechaDeRegistro;

@ManyToOne(fetch= FetchType.LAZY)
@JoinColumn(name="idUsuario", nullable=false)
private Usuario usuario;

@ManyToOne(fetch= FetchType.LAZY)
@JoinColumn(name="id_animal", nullable=false)
private Animales animal;

@Column(name="TipoDeMovimiento", nullable=false, length=30)
private String movimiento;

@Column(name="Cantidad",nullable=false)
private double cantidad;

@Column(name="UnidadMedida", nullable=false, length=20)
private String unidadMedida;

@Column(name = "ValorPorKilogramo", precision = 10, scale = 2, nullable = false)
private java.math.BigDecimal valorKilogramo; // Usa BigDecimal para precisión monetaria

@Column(name = "ValorTotal", precision = 10, scale = 2, nullable = false)
private java.math.BigDecimal valorTotal; // Usa BigDecimal para precisión monetaria

@Column(name="Detalles", nullable=true, length=100)
private String detalles;
/*------------------------------------------------------------------------------*/

    public RegistroAnimales(){}

    public RegistroAnimales(LocalDate fechaDeRegistro, String movimiento, double cantidad, String unidadMedida, BigDecimal valorKilogramo, BigDecimal valorTotal, String detalles) {
        this.fechaDeRegistro = fechaDeRegistro;
        this.movimiento = movimiento;
        this.cantidad = cantidad;
        this.unidadMedida= unidadMedida;
        this.valorKilogramo = valorKilogramo;
        this.valorTotal = valorTotal;
        this.detalles = detalles;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getFechaDeRegistro() {return fechaDeRegistro;}
    public void setFechaDeRegistro(LocalDate fechaDeRegistro) {this.fechaDeRegistro = fechaDeRegistro;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Animales getAnimal() {return animal;}
    public void setAnimal(Animales animal) {this.animal = animal;}

    public String getMovimiento() {return movimiento;}
    public void setMovimiento(String movimiento) {this.movimiento = movimiento;}

    public double getCantidad() {return cantidad;}
    public void setCantidad(double cantidad) {this.cantidad = cantidad;}

    public String getUnidadMedida() {return unidadMedida;}
    public void setUnidadMedida(String unidadMedida) {this.unidadMedida= unidadMedida;}

    public BigDecimal getValorKilogramo() {return valorKilogramo;}
    public void setValorKilogramo(BigDecimal valorKilogramo) {this.valorKilogramo = valorKilogramo;}

    public BigDecimal getValorTotal() {return valorTotal;}
    public void setValorTotal(BigDecimal valorTotal) {this.valorTotal = valorTotal;}

    public String getDetalles() {return detalles;}
    public void setDetalles(String detalles) {this.detalles = detalles;}
}
