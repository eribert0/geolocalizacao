package geolocalizacao.geolocalizacao.controllers;

import geolocalizacao.geolocalizacao.controllers.dto.VeiculoDTO;
import geolocalizacao.geolocalizacao.entities.Veiculo;
import geolocalizacao.geolocalizacao.services.VeiculoService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoDTO> getAllVeiculos() {
        return veiculoService.getAllVeiculos().stream().map(Veiculo::mapToDTO).toList();
    }

    @GetMapping("/{id}")
    public Optional<VeiculoDTO> getVeiculoById(@PathVariable Integer id) {
        return veiculoService.getVeiculoById(id).map(Veiculo::mapToDTO);
    }

    @PostMapping
    public VeiculoDTO saveVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.saveVeiculo(veiculo).mapToDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteVeiculo(@PathVariable Integer id) {
        veiculoService.deleteVeiculo(id);
    }
}
