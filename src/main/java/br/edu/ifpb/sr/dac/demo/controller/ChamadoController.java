package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.ChamadoRequestDTO;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoResponseDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService service;

    @PostMapping
    public ResponseEntity<Boolean> abrirChamado(@RequestBody @Valid ChamadoRequestDTO dto) {
        service.criar(dto);
        return ResponseEntity.created(URI.create("/1")).body(Boolean.TRUE);
    }

    @GetMapping
    public ResponseEntity<Page<ChamadoResponseDTO>> meusChamados(@RequestParam Long usuarioId,
     @PageableDefault(size = 10, sort = "titulo", direction = Sort.Direction.ASC) Pageable pageable) {

        return ResponseEntity.ok(service.MyChamados(usuarioId, pageable));
    }

}
