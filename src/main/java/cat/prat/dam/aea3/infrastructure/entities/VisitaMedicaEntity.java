package cat.prat.dam.aea3.infrastructure.entities;

import cat.prat.dam.aea3.domain.VisitaMedica;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "VisitesMediques")
public class VisitaMedicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Visita", nullable = false)
    private Integer idVisita;

    @Column(name = "Nom_Pacient", length = 40, nullable = false)
    private String nomPacient;

    @Column(name = "Nom_Metge", length = 40, nullable = false)
    private String nomMetge;

    @Column(name = "Data", nullable = false)
    private LocalDate data;

    @Column(name = "Diagnostic", length = 250, nullable = false)
    private String diagnostic;

    public VisitaMedicaEntity() {}

    public Integer getIdVisita() { return idVisita; }
    public void setIdVisita(Integer idVisita) { this.idVisita = idVisita; }
    
    public String getNomPacient() { return nomPacient; }
    public void setNomPacient(String nomPacient) { this.nomPacient = nomPacient; }
    
    public String getNomMetge() { return nomMetge; }
    public void setNomMetge(String nomMetge) { this.nomMetge = nomMetge; }
    
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    
    public String getDiagnostic() { return diagnostic; }
    public void setDiagnostic(String diagnostic) { this.diagnostic = diagnostic; }

    public static VisitaMedicaEntity fromDomain(VisitaMedica domain) {
        VisitaMedicaEntity entity = new VisitaMedicaEntity();
        if (domain.getIdVisita() != null) {
            entity.setIdVisita(domain.getIdVisita());
        }
        entity.setNomPacient(domain.getNomPacient());
        entity.setNomMetge(domain.getNomMetge());
        entity.setData(domain.getData());
        entity.setDiagnostic(domain.getDiagnostic());
        return entity;
    }

    public VisitaMedica toDomain() {
        return new VisitaMedica(idVisita, nomPacient, nomMetge, data, diagnostic);
    }
}
