package geolocalizacao.geolocalizacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import geolocalizacao.geolocalizacao.entities.Localizacao;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer>{

}
