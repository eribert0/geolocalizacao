package geolocalizacao.geolocalizacao.services;

import org.springframework.stereotype.Service;
import geolocalizacao.geolocalizacao.entities.Veiculo;
import geolocalizacao.geolocalizacao.repositories.VeiculoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    
    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        var veiculos = veiculoRepository.findAll();
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoById(Integer id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo saveVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Integer id) {
        veiculoRepository.deleteById(id);
    }
}