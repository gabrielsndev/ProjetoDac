package br.edu.ifpb.sr.dac.demo.service;

import br.edu.ifpb.sr.dac.demo.dao.ChamadoDao;
import br.edu.ifpb.sr.dac.demo.dao.UsuarioDao;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoMapper;
import br.edu.ifpb.sr.dac.demo.dto.ChamadoRequestDTO;
import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoDao daoChamado;
    private final UsuarioDao daoUser;
    private final ChamadoMapper mapper;

    public ChamadoService(ChamadoDao dao, UsuarioDao daoUser, ChamadoMapper mapper) {
        this.daoChamado = dao;
        this.daoUser = daoUser;
        this.mapper = mapper;
    }

    public void criar(ChamadoRequestDTO request) {
        Chamado chamado = mapper.toChamadoEntity(request);
        this.daoChamado.save(chamado);
    }

    public List<Chamado> MyChamados(Long idUser) {
        List<Chamado> chamados = daoChamado.findByCriador(daoUser.findById(idUser));

    }

}
