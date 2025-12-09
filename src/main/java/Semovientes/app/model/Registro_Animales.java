package Semovientes.app.model;
import jakarta.persistence.*;

@Entity
  @Table(name="Registro_Animales")

  public Class Registro_Animales{

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
    
  /*Referenciar en las tablas Usuario y Animales mediante un OneToMany a la tabla Registro de animales*/

  
  }
