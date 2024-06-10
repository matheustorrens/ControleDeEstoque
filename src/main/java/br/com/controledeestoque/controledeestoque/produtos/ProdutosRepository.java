package br.com.controledeestoque.controledeestoque.produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
    List<ProdutosModel> findByNome_produto(String nomeProduto);


}
