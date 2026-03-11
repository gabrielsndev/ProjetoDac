package br.edu.ifpb.sr.dac.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostUsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank
        String username,
        @NotBlank
        String senha,
        @NotBlank
        String confirmacaoSenha
) {}
