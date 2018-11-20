package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAceitarAmizade {

    @Autowired
    RepositorioAmizade repositorio;

    public Amizade aceitar(Amizade novaAmizade) {

        novaAmizade.setStatus(EnumStatusAmizades.AMIGOS);
        Amizade amizadeRetorno = repositorio.save(novaAmizade);

        return amizadeRetorno;
    }
}
