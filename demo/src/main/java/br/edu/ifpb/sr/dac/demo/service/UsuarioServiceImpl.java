package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.ResponseUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.mapper.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public void save(PostUsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuario.setUsername(dto.username());
        this.usuarioDao.save(usuario);
    }

    @Override
    public List<ResponseUsuarioDTO> getAll() {
        List<Usuario> usuarios = usuarioDao.findAll();
        List<ResponseUsuarioDTO> dtos = new ArrayList<ResponseUsuarioDTO>();
        for (Usuario usuario : usuarios) {
            dtos.add(UsuarioMapper.toDTO(usuario));
        }
        return dtos;
    }
}