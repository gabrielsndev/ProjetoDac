package br.edu.ifpb.sr.dac.demo.dto;

import liquibase.license.User;

public record ChamadoResponseDTO(
        User criador,
        String titulo,
        String descricao,
        String categoria,
        boolean prioridade
) {
}
