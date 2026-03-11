package br.edu.ifpb.sr.dac.demo.controller;

import br.edu.ifpb.sr.dac.demo.dto.ChamadoRequestDTO;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoResponseDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<ChamadoResponseDTO>> meusChamados(@RequestBody Long id) {
        List<ChamadoResponseDTO> chamados = service.MyChamados(id);
        return ResponseEntity.ok(chamados);
    }

}
