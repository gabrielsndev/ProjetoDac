package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.enums.CallTypes;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import liquibase.license.User;

public record ChamadoRequestDTO(

        @NotNull
        User criador,
        @NotNull
        @Size(min = 1, max = 255)
        String titulo,
        @NotNull
        @Size(min = 1, max = 300)
        String descricao,
        @NotNull
        CallTypes categoria,
        @NotNull
        boolean prioridade
) {
}
