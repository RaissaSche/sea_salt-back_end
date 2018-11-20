package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSolicitarAmizade {

    @Autowired
    RepositorioAmizade repositorio;

    public Amizade solicitar(Amizade novaAmizade) {

        novaAmizade.setStatus(EnumStatusAmizades.SOLICITADO);
        Amizade amizadeRetorno = repositorio.save(novaAmizade);

        return amizadeRetorno;
    }
}
