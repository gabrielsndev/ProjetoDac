package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PostUsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        String username,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacaoSenha,
        @Email
        String email,
        @CPF
        String cpf

) {}
