package com.Restaurant.API.service;

import com.Restaurant.API.entity.Cliente;
import com.Restaurant.API.repository.ClienteRepository;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente>lista(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> BuscarCli(String id){
        return clienteRepository.findById(id);
    }

    public void saveProcedure(Cliente cliente){
        clienteRepository.saveProcedure(cliente.getRUT_CLIENTE(),cliente.getNOMBRE_CLI(),cliente.getAPELLIDO_CLI(),cliente.getTELEFONO_CLI(), cliente.getLOGIN_USER_ID());
    }

    public void deleteCliente(String id){
        clienteRepository.deleteCliente(id);
    }


}
