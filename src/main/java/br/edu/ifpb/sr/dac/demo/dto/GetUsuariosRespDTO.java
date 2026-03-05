package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.enums.UserRole;

public record GetUsuariosRespDTO(
        Long id,
        String nome,
        String username,
        UserRole role
) {}
