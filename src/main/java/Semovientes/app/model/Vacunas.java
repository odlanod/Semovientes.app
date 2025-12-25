package Semovientes.app.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacunas")
public class Vacunas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre", nullable=false, length=40)
    private String nombre;

    @OneToMany(mappedBy="vacuna")
    private List<RegistroVacunas> registroVacuna = new ArrayList<>();

    public Vacunas() {}
    public Vacunas(String nombre) { this.nombre = nombre; }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<RegistroVacunas> getRegistroVacunas() { return registroVacuna; }
}
