package com.alianza.clienteapi.dao;

import com.alianza.clienteapi.json.ClientSearchCriteria;
import com.alianza.clienteapi.model.ClientId;
import com.alianza.clienteapi.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientDAO extends JpaRepository<ClientModel, ClientId> {
    Optional<ClientModel>getClientModelByClientId_Document(String document);

    Page<ClientModel>findByEmailContainingAndNameContainingAndPhoneContaining(String email, String name, String phone, Pageable pageable);
}
