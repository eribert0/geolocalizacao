package geolocalizacao.geolocalizacao.services;

import geolocalizacao.geolocalizacao.entities.Localizacao;
import geolocalizacao.geolocalizacao.entities.Veiculo;
import geolocalizacao.geolocalizacao.repositories.LocalizacaoRepository;
import geolocalizacao.geolocalizacao.repositories.VeiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    private final VeiculoRepository veiculoRepository;
    
    public List<Localizacao> getAllLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    public Optional<Localizacao> getLocalizacaoById(Integer id) {
        return localizacaoRepository.findById(id);
    }

    public Localizacao saveLocalizacao(Localizacao localizacao, Integer veiculoId) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
        if(veiculo.isEmpty()){
            throw new EntityNotFoundException("Veiculo não encontrado");
        }
        localizacao.setVeiculo(veiculo.get());
        return localizacaoRepository.save(localizacao);
    }

    public void deleteLocalizacao(Integer id) {
        localizacaoRepository.deleteById(id);
    }
}