package com.plantas.demo.Regas;

import com.plantas.demo.Plantas.PlantaModel;
import com.plantas.demo.Plantas.PlantaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegaService {
    private RegaRepository regaRepository;
    PlantaService plantaService;

    public RegaService(RegaRepository regaRepository, PlantaService plantaService) {
        this.regaRepository = regaRepository;
        this.plantaService = plantaService;
    }

    public RegaModel salvar(RegaModel rega){
        PlantaModel planta = plantaService.buscarPorId(
                rega.getPlanta().getId()
        );
        rega.setPlanta(planta);

        return regaRepository.save(rega);
    }
    public List<RegaModel> listar(){
        return regaRepository.findAll();

    }
    public RegaModel buscarPorId(Long id){
        return regaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id nao encontrado"));
    }

    public void deletarPorId(Long id){
        buscarPorId(id);
        regaRepository.deleteById(id);

    }


}
