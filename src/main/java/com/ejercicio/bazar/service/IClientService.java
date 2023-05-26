
package com.ejercicio.bazar.service;

import com.ejercicio.bazar.model.Client;
import java.util.List;


public interface IClientService {
    
    
    public void addClient(Client client);
    
    public List<Client> getClients();
    
    public Client getClient(Long id);
    
    public void editClient(Client client);
    
    public void deleteClient(Long id);
    
    public List<Client> getClientByName(String name);
    
}
