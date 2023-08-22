package com.alianza.clienteapi.service;

import com.alianza.clienteapi.json.ClientSearchCriteria;
import com.alianza.clienteapi.json.ClientRequest;
import com.alianza.clienteapi.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClientService {

    Page<ClientModel> getClients(Pageable pageable);

    ClientModel createClient(ClientRequest json);

    Optional<ClientModel> getClientDocumento(String document);

    ClientModel updateClient(String id, ClientRequest client);

    Boolean deleteClient(String document);

    Page<ClientModel> advancedSearch(ClientSearchCriteria clientSearchCriteria, Pageable pageable);
}
