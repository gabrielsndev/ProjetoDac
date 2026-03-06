package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import br.edu.ifpb.sr.dac.demo.model.enums.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper) {
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional
    public void saveUsuario(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setRole(UserRole.USER);
        this.usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void saveAdmin(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setRole(UserRole.ADMIN);
        this.usuarioDao.save(usuario);
    }


    @Override
    public List<GetUsuariosRespDTO> listAll() {
        return this.usuarioDao.findAll().stream().map(usuario -> new GetUsuariosRespDTO(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getRole())).toList();
    }

    @Override
    public List<GetUsuariosRespDTO> listAdmin() {
        List<Usuario> admins = this.usuarioDao.findByRole(UserRole.ADMIN);
        List<GetUsuariosRespDTO> responses = new ArrayList<>();
        for(Usuario user: admins) {
            responses.add(this.usuarioMapper.toDto(user));
        }
        return responses;
    }
}
