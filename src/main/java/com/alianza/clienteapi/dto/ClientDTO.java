package com.alianza.clienteapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ClientDTO {
    @JsonAlias
    private String name;
    @JsonAlias
    private String email;
    @JsonAlias
    private String phone;
    @JsonAlias
    private LocalDate dateAdded;
}
