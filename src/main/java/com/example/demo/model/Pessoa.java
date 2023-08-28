package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

@ToString
@Setter
@Getter
@Table(name = "pessoa") // Indica o nome da tabela no banco de dados
@Entity // Indica que é uma classe associada a um banco de dados, que será manipulada pelo JPA
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name: indica o nome da coluna no banco de dados. Caso sejam iguais, não precisa incluir
    // nullable: indica que a coluna no banco não permite nulos
    // length: indica que a coluna no banco tem um tamanho de 500 bytes
    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "pessoa_nome", length = 500, nullable = false)
    private String nome;

    @CPF
    @NotBlank(message = "O CPF é obrigatório")
    @Column(length = 11, nullable = false)
    private String cpf;

//    @Min(value = 1, message = "A idade deve ser maior do que 0")
    @NotNull(message = "A idade é obrigatória")
    private Integer idade;

    @NotNull(message = "NotNull - O campo1 não pode ser nulo")
    private String campo1;

    @NotEmpty(message = "NotEmpty - O campo2 não pode ser vazio")
    private String campo2;

    @NotBlank(message = "NotBlank - O campo3 não pode ser somente espaços")
    private String campo3;

//    @OneToMany(mappedBy = "pessoa") //, cascade = CascadeType.ALL
//    private List<Endereco> enderecos;

    @NotNull(message = "O endereço é obrigatório")
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @Valid
    private Endereco endereco;
}
