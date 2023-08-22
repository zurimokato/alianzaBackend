package com.alianza.clienteapi.controller;

import com.alianza.clienteapi.json.ClientSearchCriteria;
import com.alianza.clienteapi.json.ClientRequest;
import com.alianza.clienteapi.model.ClientModel;
import com.alianza.clienteapi.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @GetMapping
    public ResponseEntity<Page<ClientModel>> getClients(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClientModel> pages = clientService.getClients(pageable);
        return ResponseEntity.ok(pages);
    }


    @PostMapping
    public ResponseEntity<ClientModel> createClient(@Valid @RequestBody ClientRequest clientRequest) {
        ClientModel clientCreated = clientService.createClient(clientRequest);
        return ResponseEntity.created(URI.create("/api/clients/" + clientCreated.getClientId().getUserName())).body(clientCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getCliente(@PathVariable String id) {
        Optional<ClientModel> product = clientService.getClientDocumento(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> updateProduct(@PathVariable String id, @RequestBody ClientRequest client) {
        ClientModel clientUpdated = clientService.updateClient(id, client);
        if (clientUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientUpdated);
    }

    @DeleteMapping("/{document}")
    public ResponseEntity<Void>deleteClient(@PathVariable String document){
        Boolean deleted=clientService.deleteClient(document);
        if(!deleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/advanceSearch")
    public ResponseEntity<Page<ClientModel>> searchProducts(ClientSearchCriteria criteria, @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ClientModel> clientModels = clientService.advancedSearch(criteria, pageable);
        return ResponseEntity.ok(clientModels);
    }


}
