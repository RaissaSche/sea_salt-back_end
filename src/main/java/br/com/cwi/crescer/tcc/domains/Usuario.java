package br.com.cwi.crescer.tcc.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "seq", sequenceName = "SEQ_USUARIO", initialValue = 1, allocationSize = 1)
public class Usuario extends Dominio {

    private String nomeCompleto;
    @Email
    @Valid
    private String email;
    private String apelido;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;
    private String senha;
    private String imagemPerfil;
}
