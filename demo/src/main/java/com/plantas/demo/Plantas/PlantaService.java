package com.plantas.demo.Plantas;

import com.plantas.demo.Especies.EspecieModel;
import com.plantas.demo.Especies.EspecieService;
import com.plantas.demo.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaService {
    private PlantaRepository plantaRepository;
    private EspecieService especieService;

    public PlantaService(PlantaRepository plantaRepository, EspecieService especieService) {
        this.plantaRepository = plantaRepository;
        this.especieService = especieService;
    }

    public PlantaModel salvar(PlantaModel planta) {
        EspecieModel especie = especieService.buscarPorId(
                planta.getEspecie().getId()
        );

        planta.setEspecie(especie);

        return plantaRepository.save(planta);
    }
    public List<PlantaModel> listar(){

        return  plantaRepository.findAll();

    }

    public PlantaModel buscarPorId(Long id){
        return plantaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("planta nao encontrada"));
    }


    public void deletarPorId(Long id){
        buscarPorId(id);
        plantaRepository.deleteById(id);
    }

    public PlantaModel atualizar(Long id, PlantaModel plantaAtualizada){
        PlantaModel planta1 = buscarPorId(id);

        planta1.setNome(plantaAtualizada.getNome());

        return plantaRepository.save(planta1);
    }
}
