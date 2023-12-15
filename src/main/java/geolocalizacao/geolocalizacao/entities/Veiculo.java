package geolocalizacao.geolocalizacao.entities;

import java.util.List;

import geolocalizacao.geolocalizacao.controllers.dto.VeiculoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "veiculo")
@Data
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer anoFabricacao;

    @OneToMany(mappedBy = "veiculo")
    private List<Localizacao> localizacoes;

    public VeiculoDTO mapToDTO(){
        return VeiculoDTO.builder()
        .id(this.id)
        .modelo(this.modelo)
        .placa(this.placa)
        .anoFabricacao(this.anoFabricacao)
        .localizacoes(localizacoes.stream().map(Localizacao::mapToDTO).toList())
        .build();
    }

}


