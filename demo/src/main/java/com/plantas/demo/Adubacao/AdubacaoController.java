package com.plantas.demo.Adubacao;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adubacoes")
public class AdubacaoController {
    @Autowired
    private AdubacaoService adubacaoService;

    @PostMapping
    public AdubacaoModel salvar(@Valid @RequestBody AdubacaoModel adubacaoModel){
        return  adubacaoService.salvar(adubacaoModel);

    }

    @GetMapping
    public List<AdubacaoModel> listar(){
        return adubacaoService.listar();
    }

    @GetMapping("/{id}")
    public AdubacaoModel buscarPorId(@PathVariable Long id){
        return adubacaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        adubacaoService.deletarPorId(id);
    }
}
