package com.ibm.bradesco.poc.sessao.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("sessoes")
public class Sessao implements Serializable
{

    private static final long serialVersionUID=1L;

  
    @Id
    private String id;
    
    private String usuario;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
}
