package com.jtarcio.meuprimeirospringboot.controller;

import com.jtarcio.meuprimeirospringboot.model.Produto;
import com.jtarcio.meuprimeirospringboot.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable Long id){
        try{
            Produto produto = produtoService.findById(id);
            return ResponseEntity.ok(produto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}

