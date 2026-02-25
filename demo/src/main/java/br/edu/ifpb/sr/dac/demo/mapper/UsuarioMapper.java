package br.edu.ifpb.sr.dac.demo.mapper;

import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.ResponseUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.model.Usuario;

public class UsuarioMapper {

    public static ResponseUsuarioDTO toDTO(Usuario usuario) {

        return new ResponseUsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getUsername()
        );
    }
}
