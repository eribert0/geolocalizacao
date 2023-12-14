package geolocalizacao.geolocalizacao.controllers;

import geolocalizacao.geolocalizacao.entities.Veiculo;
import geolocalizacao.geolocalizacao.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> getVeiculoById(@PathVariable Integer id) {
        return veiculoService.getVeiculoById(id);
    }

    @PostMapping
    public Veiculo saveVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.saveVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Integer id) {
        veiculoService.deleteVeiculo(id);
    }
}
