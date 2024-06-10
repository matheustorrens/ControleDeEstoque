package br.com.controledeestoque.controledeestoque.produtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("produtos.html")
@Controller
public class ProdutosController {
    
    @Autowired
    private ProdutosRepository ProdutosRepository;
    
    // Adicionar um produto
    @PostMapping("/criar_projeto")
    public ResponseEntity<?> create(@RequestBody ProdutosModel produtosModel){
        var produtoExistente = this.ProdutosRepository.findByNome_produto(produtosModel.getNome_produto());
        
        if (produtoExistente != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto já cadastrado");
        }

        var produtoCriado = this.ProdutosRepository.save(produtosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    // Listar produtos
    @GetMapping("/listar-projetos")
    public ResponseEntity<List<ProdutosModel>> listarProjetos() {
        List<ProdutosModel> projetos = ProdutosRepository.findAll();
        if (projetos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(projetos);
    }
}
