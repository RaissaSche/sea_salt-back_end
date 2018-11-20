package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDesfazerAmizade {

    @Autowired
    RepositorioAmizade repositorio;

    public Amizade desfazer(Amizade amizade) {

        amizade.setStatus(EnumStatusAmizades.DESCONHECIDOS);
        Amizade amizadeRetorno = repositorio.save(amizade);

        return amizadeRetorno;
    }
}
