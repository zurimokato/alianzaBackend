package com.alianza.clienteapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "El Nombre es obligatorio")
    @NotNull
    private String name;

    @NotBlank(message = "El Email es obligatorio")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Dirección de correo electrónico no válida")
    @NotNull
    private String email;

    @NotBlank(message = "El Teléfono es obligatorio")
    @NotNull
    private String phone;

    private LocalDate dateAdded;




}
