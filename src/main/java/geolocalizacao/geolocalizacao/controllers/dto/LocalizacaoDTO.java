package geolocalizacao.geolocalizacao.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocalizacaoDTO {

    private Integer id;
    private long latitude;
    private long longitude;

}
