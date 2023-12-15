package geolocalizacao.geolocalizacao.controllers.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VeiculoDTO {
    
    private Integer id;
    private String placa;
    private String modelo;
    private Integer anoFabricacao;
    private List<LocalizacaoDTO> localizacoes;

}
