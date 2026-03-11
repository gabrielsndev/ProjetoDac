package br.edu.ifpb.sr.dac.demo.model;

import br.edu.ifpb.sr.dac.demo.model.enums.CallTypes;
import jakarta.persistence.*;
import liquibase.license.User;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

@Data
@Entity
public class Chamado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "criador_id")
    private Usuario criador;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private CallTypes categoria;
    @Column(nullable = true)
    private boolean prioridade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CallTypes getCategoria() {
        return categoria;
    }

    public void setCategoria(CallTypes categoria) {
        this.categoria = categoria;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade(boolean prioridade) {
        this.prioridade = prioridade;
    }
}
