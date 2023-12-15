package geolocalizacao.geolocalizacao.entities;

import geolocalizacao.geolocalizacao.controllers.dto.LocalizacaoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "localizacao")
@Data
public class Localizacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private long latitude;

    @Column(nullable = false)
    private long longitude;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
    
    public LocalizacaoDTO mapToDTO(){
            return LocalizacaoDTO.builder()
            .id(this.id)
            .latitude(this.latitude)
            .longitude(this.longitude)
            .build();
        }

}
