
package com.ejercicio.bazar.service;

import com.ejercicio.bazar.model.Client;
import com.ejercicio.bazar.repository.IClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    @Autowired
    private IClientRepository clientRepo;

    @Override
    public void addClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public List<Client> getClients() {
        List<Client> listClients = clientRepo.findAll();
        return listClients;
    }

    @Override
    public Client getClient(Long id) {
        Client client = clientRepo.findById(id).orElse(null);
        return client;
    }

    @Override
    public void editClient(Client client) {
        this.addClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public List<Client> getClientByName(String name) {
        
        List<Client> listClient = this.getClients();
        List<Client> listClientName = new ArrayList<>();
        for(Client client : listClient){
            if(client.getName().equals(name)){
                listClientName.add(client);
            }
        }
        return listClientName;
    }
}
