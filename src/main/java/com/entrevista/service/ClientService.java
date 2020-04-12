package com.entrevista.service;

import com.entrevista.model.Client;
import com.entrevista.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private LogService logService;

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.getOne(id);
    }

    public Client getClientByName(String name) {
        return clientRepository.findByName(name);
    }

    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    public Client saveClient(Client client) {
        Client clientCreated = null;
        try {
            clientCreated = clientRepository.save(client);
        } catch (Exception ex) {
            System.out.println("Erro ao salvar cliente: " + ex);
            //logService.saveLog("Erro ao registrar cliente [" + client.getName() + "] ");
            throw ex;
        }
        return clientCreated;
    }
}
