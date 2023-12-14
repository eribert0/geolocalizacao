package geolocalizacao.geolocalizacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import geolocalizacao.geolocalizacao.entities.Veiculo;
import geolocalizacao.geolocalizacao.repositories.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
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