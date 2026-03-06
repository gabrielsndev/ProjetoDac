package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.enums.CallTypes;
import liquibase.license.User;

public record ChamadoRequestDTO(
        User criador,
        String titulo,
        String descricao,
        CallTypes categoria,
        boolean prioridade
) {
}
