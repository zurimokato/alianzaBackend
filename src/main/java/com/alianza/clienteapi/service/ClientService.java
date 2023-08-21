package com.alianza.clienteapi.service;

import com.alianza.clienteapi.dto.ClientDTO;
import com.alianza.clienteapi.json.PageClient;
import org.springframework.data.domain.Page;

public interface ClientService {

    Page<ClientDTO>getlientes();
}
