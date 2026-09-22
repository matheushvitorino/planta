package com.plantas.demo.Plantas;

import com.plantas.demo.Especies.EspecieModel;
import com.plantas.demo.Especies.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plantas")
public class PlantaController {
    @Autowired
    private PlantaService plantaService;

    @PostMapping
    public PlantaModel salvar(@Valid @RequestBody PlantaModel planta){
        return plantaService.salvar(planta);
    }

    @GetMapping("/todos")
    public List<PlantaModel> listar(){
        return plantaService.listar();
    }

    @GetMapping("/{id}")
    public PlantaModel buscarPorId(@PathVariable Long id){
        return plantaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        plantaService.deletarPorId(id);
    }

    @PutMapping("/{id}")
    public PlantaModel atualizar(@PathVariable Long id,@Valid @RequestBody PlantaModel planta){
        return plantaService.atualizar(id, planta);
    }
}
