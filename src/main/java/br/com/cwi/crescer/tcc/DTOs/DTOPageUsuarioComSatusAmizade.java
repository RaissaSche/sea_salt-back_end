package br.com.cwi.crescer.tcc.DTOs;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DTOPageUsuarioComSatusAmizade {

    private Usuario usuario;
    private EnumStatusAmizades status;
}
