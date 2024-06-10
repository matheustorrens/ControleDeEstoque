package br.com.controledeestoque.controledeestoque.user.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.controledeestoque.controledeestoque.user.IUserRepository;
import br.com.controledeestoque.controledeestoque.user.UserModel;

@RestController
public class LoginController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserModel login) {
        UserModel user = this.userRepository.findByUsername(login.getUsername());
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
        }

        if (BCrypt.verifyer().verify(login.getPassword().toCharArray(), user.getPassword()).verified) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
        }
    }

}
