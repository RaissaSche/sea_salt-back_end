package br.com.cwi.crescer.tcc.requests.amizade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestAceitarAmizade {

    @Valid
    private Long idUsuarioLogado;
    @Valid
    private Long idOutroUsuario;
}
