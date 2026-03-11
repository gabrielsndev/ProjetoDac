package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.dto.UsuarioMapper;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import br.edu.ifpb.sr.dac.demo.model.enums.UserRole;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDao usuarioDao;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioDao usuarioDao, UsuarioMapper usuarioMapper) {
        this.usuarioDao = usuarioDao;
        this.usuarioMapper = usuarioMapper;
    }

    public void saveUsuario(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario .setRole(UserRole.USER);
        this.usuarioDao.save(usuario);
    }
    public void saveAdmin(PostUsuarioDTO dto) {
        Usuario usuario = this.usuarioMapper.toUsuarioEntity(dto);
        usuario.setRole(UserRole.ADMIN);
        this.usuarioDao.save(usuario);
    }


    public List<GetUsuariosRespDTO> listAll() {
        return this.usuarioDao.findAll().stream().map(usuario -> new GetUsuariosRespDTO(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getRole())).toList();
    }

    public Page<GetUsuariosRespDTO> listAdmin(Pageable pageable) {
        Page<Usuario> admins = this.usuarioDao.findByRole(UserRole.ADMIN, pageable);
        return admins.map(this.usuarioMapper::toDto);
    }
}
