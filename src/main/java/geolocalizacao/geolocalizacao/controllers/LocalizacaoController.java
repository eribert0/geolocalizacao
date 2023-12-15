package geolocalizacao.geolocalizacao.controllers;

import org.springframework.web.bind.annotation.*;

import geolocalizacao.geolocalizacao.controllers.dto.LocalizacaoDTO;
import geolocalizacao.geolocalizacao.entities.Localizacao;
import geolocalizacao.geolocalizacao.services.LocalizacaoService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localizacoes")
@RequiredArgsConstructor
public class LocalizacaoController {
    
    private final LocalizacaoService localizacaoService;

    @GetMapping
    public List<LocalizacaoDTO> getAllLocalizacoes() {
        return localizacaoService.getAllLocalizacoes().stream().map(Localizacao::mapToDTO).toList();
    }

    @GetMapping("/{id}")
    public Optional<LocalizacaoDTO> getLocalizacaoById(@PathVariable Integer id) {
        return localizacaoService.getLocalizacaoById(id).map(Localizacao::mapToDTO);
    }

    @PostMapping("/{veiculoId}")
    public LocalizacaoDTO saveLocalizacao(@RequestBody Localizacao localizacao, @PathVariable Integer veiculoId) {
        return localizacaoService.saveLocalizacao(localizacao, veiculoId).mapToDTO();
    }

    @DeleteMapping("/{id}")
    public void deleteLocalizacao(@PathVariable Integer id) {
        localizacaoService.deleteLocalizacao(id);
    }

}
