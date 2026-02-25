package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.ResponseUsuarioDTO;

import java.util.List;

public interface UsuarioService {
    void save(PostUsuarioDTO dto);
    List<ResponseUsuarioDTO> getAll();
}
