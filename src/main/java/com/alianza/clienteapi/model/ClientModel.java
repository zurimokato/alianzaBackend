package com.alianza.clienteapi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ClientModel  implements Serializable {


    @EmbeddedId
    private ClientId clientId;

    private String name;
    private String email;

    private String phone;

    private LocalDate dateAdded;




}
