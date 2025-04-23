package com.example.ProvaProfessor.repository;

import com.example.ProvaProfessor.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
public interface UsuRepo extends JpaRepository<Usuario, Long> {

}
