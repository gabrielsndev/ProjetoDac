package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.enums.UserRole;

public record PostUsuarioDTO(
        String nome,
        String username,
        String senha,
        String confirmacaoSenha
) {}
