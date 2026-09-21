package com.plantas.demo.Adubacao;

import com.plantas.demo.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdubacaoService {
    private AdubacaoRepository adubacaoRepository;

    public AdubacaoService(AdubacaoRepository adubacaoRepository) {
        this.adubacaoRepository = adubacaoRepository;
    }

    public AdubacaoModel salvar(AdubacaoModel adubacaoModel) {
        return adubacaoRepository.save(adubacaoModel);
    }

    public List<AdubacaoModel> listar() {
        return adubacaoRepository.findAll();
    }

    public AdubacaoModel buscarPorId(Long id) {
        return adubacaoRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("adubacao não encontrada"));
    }

    public void deletarPorId(Long id) {
        buscarPorId(id);
        adubacaoRepository.deleteById(id);
    }

}
