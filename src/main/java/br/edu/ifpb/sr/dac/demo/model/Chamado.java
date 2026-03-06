package br.edu.ifpb.sr.dac.demo.model;

import br.edu.ifpb.sr.dac.demo.model.enums.CallTypes;
import jakarta.persistence.*;
import liquibase.license.User;
import lombok.Data;

@Data
@Entity
public class Chamado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private User criador;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private CallTypes categoria;
    @Column(nullable = true)
    private boolean prioridade;
}
