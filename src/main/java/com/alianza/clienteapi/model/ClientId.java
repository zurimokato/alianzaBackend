package com.alianza.clienteapi.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;


import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ClientId implements Serializable {


    @NotNull
    private String userName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private String document;
}
