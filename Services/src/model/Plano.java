package model;

import java.util.ArrayList;
import java.util.List;

public class Plano {
    private Integer idPlano;
    private String nome;
    private String descricao;
    private Float valor;
    private List<Cliente> clientes;

    public Plano() {
        this.clientes = new ArrayList<Cliente>();
    }
    
    public void addClient(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public void removeClient(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public Integer getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(Integer idPlano) {
        this.idPlano = idPlano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
}
