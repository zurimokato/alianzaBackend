package com.alianza.clienteapi.service.imp;

import com.alianza.clienteapi.dto.ClientDTO;
import com.alianza.clienteapi.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public Page<ClientDTO> getlientes() {
        return null;
    }
}
