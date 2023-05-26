
package com.ejercicio.bazar.controller;

import com.ejercicio.bazar.model.Client;
import com.ejercicio.bazar.service.IClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {
    @Autowired
    private IClientService clientServ;
    
    @GetMapping("/")
    public List<Client> getClients(){
        List<Client> listClients = clientServ.getClients();
        return listClients;
    }
    
    @PostMapping("/agregar")
    public String addClient(@RequestBody Client client){
        
        clientServ.addClient(client);
        
        return "Se creó un cliente con el id " + " " + client.getIdClient();
    }
    
    
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        Client client =clientServ.getClient(id);
        return client;
    }
    
    @GetMapping("")
    @ResponseBody
    public List<Client> getClientByName(@RequestParam String name){
        List<Client> clientsName = clientServ.getClientByName(name);
        return clientsName;
    }
    
    
    @PutMapping("/editar")
    public String editClient(@RequestBody Client client){
        
        clientServ.editClient(client);
               
        return "Se editó el cliente con el id " + " " + client.getIdClient();
    
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteClient(@PathVariable Long id){
        clientServ.deleteClient(id);
        return "Se eliminó correctamente el cliente";
    
    }
    
    
    
    
}
