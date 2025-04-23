package com.example.ProvaProfessor.dto;

import com.example.ProvaProfessor.entity.Usuario;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class UsuDTO implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String username;
    private int senha;
    private LocalDate dataNasc;

    public UsuDTO() {
    }

    public UsuDTO(Long id, String nome, String sobrenome, String cpf, String email, String username, int senha, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
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
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNasc()
        );
    }


}
