package br.com.controledeestoque.controledeestoque.produtos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("produtos.html")
@Controller
public class ProdutosController {
    
    @GetMapping("")
    public void produtos() {

    }
}
