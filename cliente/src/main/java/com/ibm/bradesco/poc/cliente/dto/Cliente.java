package com.ibm.bradesco.poc.cliente.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
    
    public Cliente()
    {
        
    }

    public Cliente(String nome, String email, String telefone)
    {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cd_cliente")
    private long id;

    @Column(name="nm_cliente")
    private String nome;

    @Column(name="nm_email")
    private String email;

    @Column(name="nm_telefone")
    private String telefone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString()
    {
        return "Cliente [id="+ this.id + ". nome="  + this.nome + ", email=" + this.email + ", telefone="+ this.telefone;        
    }
    
}
