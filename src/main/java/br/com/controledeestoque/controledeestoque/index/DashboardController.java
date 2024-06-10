package br.com.controledeestoque.controledeestoque.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.controledeestoque.controledeestoque.produtos.ProdutosRepository;
import br.com.controledeestoque.controledeestoque.produtos.ProdutosModel;

@RestController
public class DashboardController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping("/card1")
    public String card1() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        return "Produtos (" + produtos.size() + ")";
    }

    @GetMapping("/card2")
    public String card2() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        double somaPrecos = 0;
        for (ProdutosModel produto : produtos) {
            somaPrecos += Double.parseDouble(produto.getPreco_venda().replace(",", "."));
        }
        String formattedValue = somaPrecos >= 0 ? "+R$" + somaPrecos : "-R$" + Math.abs(somaPrecos);
        return formattedValue;
    }

    @GetMapping("/card3")
    public int card3() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        int contador = 0;
        for (ProdutosModel produto : produtos) {
            if (Integer.parseInt(produto.getQtde_produto()) <= 5) {
                contador++;
            }
        }
        return contador;
    }

    @GetMapping("/card4")
    public int card4() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        int contador = 0;
        for (ProdutosModel produto : produtos) {
            if (Integer.parseInt(produto.getQtde_produto()) == 0) {
                contador++;
            }
        }
        return contador;
    }
}
