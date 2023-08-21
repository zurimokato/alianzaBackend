package com.alianza.clienteapi.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ClientId implements Serializable {

    private String sharedKey;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessId;
}
