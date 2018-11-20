package br.com.cwi.crescer.tcc.requests.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSalvarUsuario {

    @NotEmpty
    private String nomeCompleto;
    @Email
    @NotEmpty
    private String email;
    private String apelido;
    @NotEmpty
    private String senha;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataDeNascimento;
    @NotEmpty
    private String imagemPerfil;
}
