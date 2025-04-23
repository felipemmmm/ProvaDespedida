package com.example.ProvaProfessor.service;

import com.example.ProvaProfessor.dto.UsuDTO;
import com.example.ProvaProfessor.entity.Usuario;
import com.example.ProvaProfessor.repository.UsuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuService {

    @Autowired
    private UsuRepo usuRepo;

    //1. Buscar todos
    public List<Usuario> getAllUsers() {
        return usuRepo.findAll();
    }

    //2. Buscar pelo ID
    public Optional<UsuDTO> getById(Long id){
        Optional<Usuario> usuarioOptional =usuRepo.findById(id);
        if (usuarioOptional.isPresent()){
            UsuDTO usuDTO = new UsuDTO();
            return Optional.of(usuDTO.fromUsuario(usuarioOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    //3. Criar um Usuario
    public UsuDTO createUser(UsuDTO usuDTO){
        Usuario usuario = usuDTO.toUsuario();
        usuario = usuRepo.save(usuario);
        return usuDTO.fromUsuario(usuario);
    }

    //4. Atualizar dados menos username e senha
    public Optional<UsuDTO> updateUser(Long id, UsuDTO usuDTO){
        Optional<Usuario> usuarioOptional = usuRepo.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuDTO.getNome());
            usuario.setSobrenome(usuDTO.getSobrenome());
            usuario.setCpf(usuDTO.getCpf());
            usuario.setEmail(usuDTO.getEmail());
            usuario.setDataNasc(usuDTO.getDataNasc());

            usuario = usuRepo.save(usuario);

            return Optional.of(usuDTO.fromUsuario(usuario));
        } else {
            return Optional.empty();
        }
    }

    //5. Atualizar senha
    public Optional<UsuDTO> updatePassword(Long id, UsuDTO usuDTO){
        Optional<Usuario> usuarioOptional = usuRepo.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setSenha(usuDTO.getSenha());

            usuario = usuRepo.save(usuario);

            return Optional.of(usuDTO.fromUsuario(usuario));
        } else {
            return Optional.empty();
        }
    }

    //6. Deletar usuario
    public boolean delete(Long id){
        if(usuRepo.existsById(id)){
            usuRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //7. Buscar pelo nome
    public Optional<UsuDTO> getByNomeAndSobrenome(String nome, String sobrenome){
        Optional<Usuario> usuarioOptional = usuRepo.findByNomeAndSobrenome(nome, sobrenome);
        if (usuarioOptional.isPresent()){
            UsuDTO usuDTO = new UsuDTO();
            return Optional.of(usuDTO.fromUsuario(usuarioOptional.get()));
        } else {
            return Optional.empty();
        }
    }

    //8. Buscar pelo CPF
    public Optional<UsuDTO> getByCPF(String cpf){
        Optional<Usuario> usuarioOptional = usuRepo.findByCpf(cpf);
        if (usuarioOptional.isPresent()){
            UsuDTO usuDTO = new UsuDTO();
            return Optional.of(usuDTO.fromUsuario(usuarioOptional.get()));
        } else {
            return Optional.empty();
        }
    }
}
