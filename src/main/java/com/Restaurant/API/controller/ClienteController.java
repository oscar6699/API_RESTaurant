package com.Restaurant.API.controller;

import com.Restaurant.API.entity.Cliente;
import com.Restaurant.API.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> lista(){
        List<Cliente>lista=clienteService.lista();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Cliente> obtenerCLiente(@PathVariable("id") String id){
        Optional<Cliente> optionalCliente = this.clienteService.BuscarCli(id);
        if (optionalCliente.isPresent())
            return new ResponseEntity<>(optionalCliente.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> save(@RequestBody Cliente cliente){
        clienteService.saveProcedure(cliente);
        return new ResponseEntity<>("Cliente Creado",HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") String id){
        clienteService.deleteCliente(id);
        return new ResponseEntity<>("Cliente Elimnado",HttpStatus.OK);
    }
}
