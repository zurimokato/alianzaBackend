package com.alianza.clienteapi.json;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientSearchCriteria {
    private String name;
    private String email;
    private String phone;
}
