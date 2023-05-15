package com.ibm.bradesco.poc.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ibm.bradesco.poc.cliente.dto.Cliente;
import com.ibm.bradesco.poc.cliente.jpa.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    ClienteRepositorio repositorio;


    @GetMapping("/ambiente")
    public String getAmbiente()
    {
        return System.getenv("AMBIENTE");
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getTodosClientes(@RequestParam(required = false) String email)
    {
        try
        {
            List<Cliente> clientes = new ArrayList<Cliente>();

            if (email == null)
            {
                repositorio.findAll().forEach(clientes::add);
            }
            else
            {
                repositorio.findByEmail(email).forEach(clientes::add);
            }
            if (clientes.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }
        catch (Exception  e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") long id)
    {
        Optional<Cliente> clienteData = repositorio.findById(id);

        if (clienteData.isPresent())
        {
            return new ResponseEntity<>(clienteData.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } 
    
    @PostMapping("/clientes")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente)
    {
        try
        {
            Cliente cli = repositorio.save(new Cliente(cliente.getNome(), cliente.getEmail(), cliente.getTelefone()));
            return new ResponseEntity<>(cli, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
