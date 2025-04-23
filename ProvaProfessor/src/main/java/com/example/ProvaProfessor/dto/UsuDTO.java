package com.example.ProvaProfessor.dto;

import com.example.ProvaProfessor.entity.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Data
public class UsuDTO implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String CPF;
    private String email;
    private String username;
    private int senha;
    private LocalDate dataNasc;

    public UsuDTO() {
    }

    public UsuDTO(Long id, String nome, String sobrenome, String CPF, String email, String username, int senha, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.CPF,
                this.email,
                this.username,
                this.senha,
                this.dataNasc);
    }

    public UsuDTO fromUsuario(Usuario usuario){
        return new UsuDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNasc()
        );
    }
}
