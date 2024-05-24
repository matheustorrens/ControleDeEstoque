package br.com.controledeestoque.controledeestoque.user.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login.html")
@Controller
public class LoginController {

    @GetMapping("")
    public void login() {

    }

}
