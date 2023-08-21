package com.alianza.clienteapi.service.imp;

import com.alianza.clienteapi.dao.ClientDAO;
import com.alianza.clienteapi.json.AdvancedSearch;
import com.alianza.clienteapi.json.ClientRequest;
import com.alianza.clienteapi.model.ClientId;
import com.alianza.clienteapi.model.ClientModel;
import com.alianza.clienteapi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;
    @Override
    public Page<ClientModel> getClients(Pageable pageable) {
        return clientDAO.findAll(pageable);
    }

    @Override
    public ClientModel createClient(ClientRequest json) {
        ClientModel client=new ClientModel();
        client.setName(json.getName());
        client.setPhone(json.getPhone());
        client.setEmail(json.getEmail());
        client.setDateAdded(LocalDate.now());
        client.setClientId(new ClientId());
        client.getClientId().setUserName(json.getUserName());
        client.getClientId().setDocument(json.getDocument());
        return clientDAO.save(client);
    }

    @Override
    public Optional<ClientModel> getClientDocumento(String document) {
        return clientDAO.getClientModelByClientId_Document(document);
    }

    @Override
    public ClientModel updateClient(String id, ClientRequest client) {

        ClientModel clientToUpdate=clientDAO.getClientModelByClientId_Document(id).orElse(null);
        if (clientToUpdate  ==null) {
            return null;
        }
        clientToUpdate.setName(client.getName());
        clientToUpdate.setPhone(client.getPhone());
        clientToUpdate.setEmail(client.getEmail());
        return clientDAO.save(clientToUpdate);
    }

    @Override
    public Boolean deleteClient(String document) {
        ClientModel clientToDelete=clientDAO.getClientModelByClientId_Document(document).orElse(null);
        if (clientToDelete  ==null) {
            return false;
        }
        clientDAO.delete(clientToDelete);
        return true;
    }

    @Override
    public Page<ClientModel> advancedSearch(AdvancedSearch advancedSearch, Pageable pageable) {
        return clientDAO.searchClientModels(advancedSearch,pageable);
    }
}
