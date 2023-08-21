package com.alianza.clienteapi.json;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Getter
@Setter
public class ClientRequest {
    @NotBlank(message = "El Nombre es obligatorio")
    @NotNull
    private String name;

    @NotBlank(message = "El UserName es obligatorio")
    @NotNull
    private String userName;

    @NotBlank(message = "El Email es obligatorio")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Dirección de correo electrónico no válida")
    @NotNull
    private String email;

    @NotBlank(message = "El Teléfono es obligatorio")
    @NotNull
    private String phone;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @NotBlank(message = "El documento es obligatorio")
    private String document;
}
