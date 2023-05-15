package com.ibm.bradesco.poc.sessao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ibm.bradesco.poc.sessao.dto.Sessao;
import com.ibm.bradesco.poc.sessao.jpa.SessaoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SessaoControler {
    
    @Autowired
    private SessaoRepositorio repositorio; // = new SessaoRepositorio();

    @GetMapping("/ambiente")
    public String getAmbiente()
    {
        return System.getenv("AMBIENTE");
    }

    @GetMapping("/sessoes")
    public ResponseEntity<List<Sessao>> getTodasSessoes()
    {
        try
        {
            List<Sessao> sessoes = new ArrayList<Sessao>();
            repositorio.findAll().forEach(sessoes::add);
            return new ResponseEntity<>(sessoes, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sessoes/{id}")
    public ResponseEntity<Sessao> getSessao(@PathVariable String id)
    {
        Optional<Sessao> sessao = repositorio.findById(id);
        if (sessao.isPresent())
        {
            return new ResponseEntity<>(sessao.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/sessoes")
    public ResponseEntity<Sessao> addSessao(@RequestBody Sessao sessao)
    {
        try
        {
            System.out.println(sessao.getUsuario());
            Sessao newSession = repositorio.save(sessao);
            return new ResponseEntity<>(newSession, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/sessoes")
    public ResponseEntity<Sessao> deleteAllSessions()
    {
        try
        {
            List<Sessao> sessoes = new ArrayList<Sessao>();
            repositorio.findAll().forEach(sessoes::add);
            for (Sessao sessao: sessoes)
            {
                repositorio.delete(sessao);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/sessoes/{id}")
    public ResponseEntity<Sessao> deleteSessao(@PathVariable String id)
    {
        try
        {
            Optional<Sessao> sessao = repositorio.findById(id);
            if (sessao.isPresent())
            {
                Sessao temp = sessao.get();
                repositorio.delete(temp);
                return new ResponseEntity<>(temp, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
