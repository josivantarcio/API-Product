package com.jtarcio.meuprimeirospringboot.repository;

import com.jtarcio.meuprimeirospringboot.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para a entidade Produto.
 *
 * Ao estender JpaRepository<Produto, Long>:
 * - Produto: é a entidade que será gerenciada
 * - Long: é o tipo da chave primária (ID)
 *
 * O Spring Data JPA cria automaticamente a implementação desta interface
 * com métodos CRUD prontos:
 * - save(produto) - Salvar/Atualizar
 * - findById(id) - Buscar por ID
 * - findAll() - Buscar todos
 * - deleteById(id) - Deletar por ID
 * - count() - Contar registros
 * - existsById(id) - Verificar se existe
 *
 * Além disso, podemos criar métodos customizados usando convenções de nomenclatura
 * do Spring Data JPA (Query Methods).
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos CRUD herdados automaticamente do JpaRepository

    // Exemplos de métodos customizados que podem ser adicionados:
    // List<Produto> findByNome(String nome);
    // List<Produto> findByPrecoGreaterThan(Double preco);
    // Optional<Produto> findByNomeAndPreco(String nome, Double preco);
}