package com.alianza.clienteapi.controller;

import com.alianza.clienteapi.dto.ClientDTO;
import com.alianza.clienteapi.json.PageClient;
import com.alianza.clienteapi.model.ClientModel;
import com.alianza.clienteapi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @GetMapping
    public ResponseEntity<Page<ClientDTO>>getClients(){
        Page<ClientDTO>pages=clientService.getlientes();
        return ResponseEntity.ok(pages);
    }




}
