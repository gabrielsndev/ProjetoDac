package br.edu.ifpb.sr.dac.demo.dao;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoDao extends JpaRepository<Chamado, Long> {

}
