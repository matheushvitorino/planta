package com.plantas.demo.Especies;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecieService {

    private EspecieRepository especieRepository;
    public EspecieService(EspecieRepository especieRepository) {this.especieRepository = especieRepository;}

    public EspecieModel salvar(EspecieModel especie){
        return especieRepository.save(especie);
    }

    public List<EspecieModel> listar(){

        return  especieRepository.findAll();

    }

    public EspecieModel buscarPorId(Long id){
        return especieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id nao encontrado"));
    }

    public void deletarPorId(Long id){
        buscarPorId(id);
        especieRepository.deleteById(id);
    }

    public EspecieModel atualizar(Long id, EspecieModel especieAtualizada){
        EspecieModel especie1 = buscarPorId(id);

        especie1.setNome(especieAtualizada.getNome());

        return especieRepository.save(especie1);
    }

}
