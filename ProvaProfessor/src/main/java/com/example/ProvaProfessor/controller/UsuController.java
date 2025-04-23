package com.example.ProvaProfessor.controller;

import com.example.ProvaProfessor.dto.UsuDTO;
import com.example.ProvaProfessor.entity.Usuario;
import com.example.ProvaProfessor.service.UsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cadastro")
public class UsuController {

    @Autowired
    private UsuService usuService;

    //1. Buscar todos
    @GetMapping
    public List<Usuario> getAll(){
        return usuService.getAllUsers();
    }

    //2. Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuDTO> getById(@PathVariable Long id){
        Optional<UsuDTO> usuDTOOptional = usuService.getById(id);
        return usuDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); //java que fez sozin
    }

    //3. Add User
    @PostMapping
    public ResponseEntity<UsuDTO> create(@RequestBody UsuDTO usuDTO){
        UsuDTO usuDTOSave = usuService.createUser(usuDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuDTOSave);
    }

    //4. Update User menos username e senha
    @PutMapping("/{id}")
    public ResponseEntity<UsuDTO> updateUser(@PathVariable Long id, @RequestBody UsuDTO usuDTO){
        Optional<UsuDTO> usuDTOOptional = usuService.updateUser(id, usuDTO);
        return usuDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //5. Update senha
    @PutMapping("/{id}/senha")
    public ResponseEntity<UsuDTO> updatePassword(@PathVariable Long id, @RequestBody UsuDTO usuDTO) {
        Optional<UsuDTO> usuDTOOptional = usuService.updatePassword(id,usuDTO);
        return usuDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //6. Deletar user
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        if(usuService.delete(id)){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //7. Buscar pelo cpf
    @GetMapping("/{cpf}/buscaCpf")
    public ResponseEntity<UsuDTO> getByCpf(@PathVariable String cpf) {
        Optional<UsuDTO> usuDTOOptional = usuService.getByCPF(cpf);
        return usuDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //8. Buscar pelo nome
    @GetMapping("/{nome}/{sobrenome}")
    public ResponseEntity<UsuDTO> getByNomeAndSobrenome(@PathVariable String nome, String sobrenome) {
        Optional<UsuDTO> usuDTOOptional = usuService.getByNomeAndSobrenome(nome, sobrenome);
        return usuDTOOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
