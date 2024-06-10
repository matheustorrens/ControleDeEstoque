package br.com.controledeestoque.controledeestoque.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // @Column indica que a variável abaixo é uma coluna unica, não poderá ter duas
    // iguais no banco de dados.
    @Column(unique = true)
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String ConfirmaSenha;

    // @CreationTimestamp indica que a variável abaixo será criada automaticamente
    @CreationTimestamp
    private LocalDateTime createdAt;

    public String getUsername() {
        return this.nome;
    }

    public String getPassword() {
        return this.senha;
    }

    public void setPassword(Object password) {
        String senha_string = password.toString();
        this.senha = senha_string;
    }

}
