package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.GetUsuariosRespDTO;
import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import br.edu.ifpb.sr.dac.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("create")
    public ResponseEntity<Boolean> criarUsuario(@RequestBody @Valid PostUsuarioDTO dto) {
        this.usuarioService.saveUsuario(dto);
        return ResponseEntity.created(URI.create("/1")).body(Boolean.TRUE);
    }

    @PostMapping("/create/admin")
    public ResponseEntity<Boolean> criarAdmin(@RequestBody @Valid PostUsuarioDTO dto) {
        this.usuarioService.saveAdmin(dto);
        return ResponseEntity.created(URI.create("/1")).body(Boolean.TRUE);
    }


    @GetMapping
    public ResponseEntity<List<GetUsuariosRespDTO>> getAllUsuarios() {
        return ResponseEntity.ok(this.usuarioService.listAll());
    }

    @GetMapping("/listar/admins")
    public ResponseEntity<Page<GetUsuariosRespDTO>> listAllAdmin(
            @PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.ASC)
            Pageable pageable
    ) {
        return ResponseEntity.ok(this.usuarioService.listAdmin(pageable));
    }
}
