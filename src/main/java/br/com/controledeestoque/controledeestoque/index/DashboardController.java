package br.com.controledeestoque.controledeestoque.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("index.html")
@Controller
public class DashboardController {

    @GetMapping("")
    public void dashboard() {

    }

    @PostMapping("/salvarUsuario")
    public void salvarUsuario() {
        System.out.println("\n\n Eu amo a Manu \n\n");
    }
    
}
