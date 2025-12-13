package Semovientes.app.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="Registro_Animales")

public class Registro_Animales{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="fecha_Registro", nullable=false)
private LocalDate fecha_Registro;

@ManyToOne(fetch= FetchType.LAZY)
@JoinColumn(name="idUsuario", nullable=false)
private Usuario usuario;

@ManyToOne(fetch= FetchType.LAZY)
@JoinColumn(name="id_animal", nullable=false)
private Animales animal;

@Column(name="Tipo_Movimiento", nullable=false, length=30)
private String movimiento;

@Column(name="Cantidad",nullable=false)
private double cantidad;

@Column(name="U/M", nullable=false, length=20)
private String UM;

@Column(name = "Valor_Kilogramo", precision = 10, scale = 2, nullable = false)
private java.math.BigDecimal valorKilogramo; // Usa BigDecimal para precisión monetaria

@Column(name = "Valor_Total", precision = 10, scale = 2, nullable = false)
private java.math.BigDecimal valorTotal; // Usa BigDecimal para precisión monetaria

@Column(name="Detalles", nullable=true, length=100)
private String detalles;
/*------------------------------------------------------------------------------*/

    public Registro_Animales(){}

    public Registro_Animales(LocalDate fecha_Registro, String movimiento, double cantidad, String UM, BigDecimal valorKilogramo, BigDecimal valorTotal, String detalles) {
        this.fecha_Registro = fecha_Registro;
        this.movimiento = movimiento;
        this.cantidad = cantidad;
        this.UM = UM;
        this.valorKilogramo = valorKilogramo;
        this.valorTotal = valorTotal;
        this.detalles = detalles;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public LocalDate getFecha_Registro() {return fecha_Registro;}
    public void setFecha_Registro(LocalDate fecha_Registro) {this.fecha_Registro = fecha_Registro;}

    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public Animales getAnimal() {return animal;}
    public void setAnimal(Animales animal) {this.animal = animal;}

    public String getMovimiento() {return movimiento;}
    public void setMovimiento(String movimiento) {this.movimiento = movimiento;}

    public double getCantidad() {return cantidad;}
    public void setCantidad(double cantidad) {this.cantidad = cantidad;}

    public String getUM() {return UM;}
    public void setUM(String UM) {this.UM = UM;}

    public BigDecimal getValorKilogramo() {return valorKilogramo;}
    public void setValorKilogramo(BigDecimal valorKilogramo) {this.valorKilogramo = valorKilogramo;}

    public BigDecimal getValorTotal() {return valorTotal;}
    public void setValorTotal(BigDecimal valorTotal) {this.valorTotal = valorTotal;}

    public String getDetalles() {return detalles;}
    public void setDetalles(String detalles) {this.detalles = detalles;}
}
