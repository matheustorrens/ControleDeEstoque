package br.com.controledeestoque.controledeestoque.user.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("register.html")
@Controller
public class RegisterController {
    
    @GetMapping("")
    public void register() {

    }
}
