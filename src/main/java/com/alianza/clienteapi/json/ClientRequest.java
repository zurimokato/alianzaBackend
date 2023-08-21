package com.alianza.clienteapi.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
    private String name;
    private String sharedKey;
    private String email;
    private String phone;

}
