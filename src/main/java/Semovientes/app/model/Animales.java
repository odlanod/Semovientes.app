package Semovientes.app.model;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Animales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_animal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="finca_id")
    private int id_finca;

    @Column(name="nombre_animal", nullable=true, length=40)
    private String nombre;

    @Column(name="especie_animal", nullable = false, length=30)
    private String especie;

    @Column(name="raza_animal", nullable=false, length=30)
    private String raza;

    @Column(name="sexo_animal", nullable=false, length=20)
    private String sexo;

    @Column(name="tipo_adquisicion", nullable= false, length=30)
    private String adquisicion;

    @Column(name="fecha", nullable= false)
    private LocalDate fecha;

    @Column(name="peso_inicial", nullable= false, length= 20)
    private double pesoInicial;

    @Column(name="estado_animal", nullable=false, length=30)
    private String estadoAnimal;

    @ManyToOne
    @JoinColumn(name="id_madre",nullable=false)
    private Animales id_madre;

    @ManyToOne
    @JoinColumn(name="id_padre",nullable=false)
    private Animales id_padre;



}

