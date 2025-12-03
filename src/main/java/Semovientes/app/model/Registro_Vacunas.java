package Semovientes.app.model;
import jakarta.persistence.*;

@Entity
  @Table(name="Registro_Vacunas)
  public class Registro_Vacunas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animales animal;

    @ManyToOne(fetch= FetchType.Lazy)
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
    

  
  }
  
