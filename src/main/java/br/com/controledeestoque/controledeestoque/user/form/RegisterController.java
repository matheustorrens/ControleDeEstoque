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
public class RegisterController {
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserModel newUser) {
        UserModel existingUser = this.userRepository.findByUsername(newUser.getUsername());
        
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        String passwordHashed = BCrypt.withDefaults().hashToString(12, newUser.getPassword().toCharArray());
        newUser.setPassword(passwordHashed);

        UserModel createdUser = this.userRepository.save(newUser);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
