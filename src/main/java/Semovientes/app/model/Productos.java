package Semovientes.app.model;
import jakarta.persistence.*;

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

}

