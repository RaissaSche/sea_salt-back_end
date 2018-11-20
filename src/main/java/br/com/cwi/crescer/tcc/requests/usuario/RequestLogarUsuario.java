package br.com.cwi.crescer.tcc.requests.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLogarUsuario {

    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String senha;
}
