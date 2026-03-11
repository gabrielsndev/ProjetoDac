package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import br.edu.ifpb.sr.dac.demo.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChamadoDao extends JpaRepository<Chamado, Long> {
    Page<Chamado> findByCriador(Optional<Usuario> u, Pageable pageable);
}
