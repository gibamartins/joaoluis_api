package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController configura a classe como um controlador, responsável por receber requisições.
// Esta anotação define que as respostas, por padrão, serão produzidas no formato JSON.
@RestController
// RequestMapping indica qual a URL que esse controlador responderá às requisições
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    //@RequestBody: Indica para o Spring que os dados recebidos estão no BODY da mensagem
    //@PostMapping: Cria uma URI para receber requisições do tipo "POST", com o endereço "/pessoas"
    @PostMapping
    public void save(@RequestBody @Valid Pessoa pessoa) {
        System.out.println("\n\nPessoa: " +  pessoa);
        this.repository.save(pessoa);
    }

    //@GetMapping: Cria uma URI para receber requisições do tipo "GET", com o endereço "/pessoas"
    @GetMapping
    public List<Pessoa> findAll() {
        return this.repository.findAll();
    }

    //@GetMapping("/{pessoaId}"): Cria uma URI para receber requisições do tipo "GET", com o endereço "/pessoas/1",
    // sendo que o "1" indica o identificador único para a pessoa que se deseja buscar os dados.
    @GetMapping("/{pessoaId}")
    public Pessoa findById(@PathVariable("pessoaId") Long pessoaId) {
        return this.repository.findById(pessoaId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }
}
