package geolocalizacao.geolocalizacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import geolocalizacao.geolocalizacao.entities.Localizacao;
import geolocalizacao.geolocalizacao.services.LocalizacaoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {
    
    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public List<Localizacao> getAllLocalizacoes() {
        return localizacaoService.getAllLocalizacoes();
    }

    @GetMapping("/{id}")
    public Optional<Localizacao> getLocalizacaoById(@PathVariable Integer id) {
        return localizacaoService.getLocalizacaoById(id);
    }

    @PostMapping("/{veiculoId}")
    public Localizacao saveLocalizacao(@RequestBody Localizacao localizacao, @PathVariable Integer veiculoId) {
        return localizacaoService.saveLocalizacao(localizacao, veiculoId);
    }

    @DeleteMapping("/{id}")
    public void deleteLocalizacao(@PathVariable Integer id) {
        localizacaoService.deleteLocalizacao(id);
    }

}
