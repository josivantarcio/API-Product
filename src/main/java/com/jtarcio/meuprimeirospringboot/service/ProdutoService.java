package com.jtarcio.meuprimeirospringboot.service;

import com.jtarcio.meuprimeirospringboot.exceptions.RecursoNaoEncontradoException;
import com.jtarcio.meuprimeirospringboot.model.Produto;
import com.jtarcio.meuprimeirospringboot.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    /*
     * CONTRUTOR COM ARGUMENTOS CRIADO PELO LOMBOK!
     */

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto Não Encontrado de ID: " + id));
    }

    public Produto salvarProduto(Produto prod) {
        if (prod.getPreco() > 0) {
            return produtoRepository.save(prod);
        } else {
            throw new RuntimeException("Valor abaixo do permitido");
        }
    }

    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto de id + " + id + " não encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
