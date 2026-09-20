package com.plantas.demo.Especies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("especies")
public class EspecieController {
    @Autowired
    private EspecieService especieService;

    @PostMapping
    public EspecieModel salvar(@RequestBody EspecieModel especie){
        return especieService.salvar(especie);
    }

    @GetMapping("/todos")
    public List<EspecieModel> listar(){
        return especieService.listar();
    }

    @GetMapping("/{id}")
    public EspecieModel buscarPorId(@PathVariable Long id){
        return especieService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        especieService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    public EspecieModel atualizar(@PathVariable Long id,@RequestBody EspecieModel especie){
        return especieService.atualizar(id, especie);
    }
}
