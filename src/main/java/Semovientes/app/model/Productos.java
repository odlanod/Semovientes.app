package Semovientes.app.model;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name="nombre_producto",nullable= false,length=50)
    private String nombre;
  
    @Column(name="tipo_producto",nullable= false,length=30)
    private String tipoProducto;
  
    @Column(name="unidad_medida", nullable=false, precision = 5, scale = 2) 
    private BigDecimal unidadMedida;
  
    @Column(name="valor_unitario", nullable=false, precision = 10, scale = 2) 
    private BigDecimal valorUnitario;

    @Column(name="estado_producto", nullable=false)
    private boolean estado;

    /**************************CONSTRUCTORES*************************/
    public Productos(String nombre, String tipoProducto, BigDecimal unidadMedida, BigDecimal valorUnitario, boolean estado) {
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
        this.unidadMedida = unidadMedida;
        this.valorUnitario = valorUnitario;
        this.estado = estado;
    }

    public Productos(){}

    /************************GETTER Y SETTERS***********************/
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(BigDecimal unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}

