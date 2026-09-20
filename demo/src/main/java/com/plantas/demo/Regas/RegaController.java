package com.plantas.demo.Regas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("regas")
public class RegaController {
    @Autowired
    private RegaService regaService;

    @PostMapping
    public RegaModel salvar(@RequestBody RegaModel regaModel){
        return regaService.salvar(regaModel);
    }

    @GetMapping
    public List<RegaModel> listar(){
        return regaService.listar();
    }

    @GetMapping("/{id}")
    public RegaModel buscarPorId(@PathVariable Long id){
        return regaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        regaService.deletarPorId(id);
    }

}
