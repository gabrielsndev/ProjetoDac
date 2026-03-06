package br.edu.ifpb.sr.dac.demo.dto;

import br.edu.ifpb.sr.dac.demo.model.Chamado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    Chamado toChamadoEntity(ChamadoRequestDTO dto);

    ChamadoResponseDTO toDto(Chamado chamado);
}
