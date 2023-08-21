package com.alianza.clienteapi.dao;

import com.alianza.clienteapi.model.ClientId;
import com.alianza.clienteapi.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientDAO extends JpaRepository<ClientModel, ClientId> {
}
