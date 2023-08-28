package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O logradouro, da classe Endereco, é obrigatório")
    @Column(length = 512, nullable = false)
    private String logradouro;

    @Column(length = 250, nullable = false)
    private String bairro;

    @Column(length = 250)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    private Pessoa pessoa;
}
