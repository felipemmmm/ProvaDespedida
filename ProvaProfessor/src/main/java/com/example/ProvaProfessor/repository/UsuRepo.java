package com.example.ProvaProfessor.repository;

import com.example.ProvaProfessor.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuRepo extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNomeAndSobrenome(String nome, String sobrenome);
    Optional<Usuario> findByCpf(String cpf);
}
