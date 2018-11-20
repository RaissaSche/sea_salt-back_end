package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceChecarStatusAmizade {

    @Autowired
    ServiceBuscarAmizadePorId serviceBuscarAmizadePorId;

    public Amizade checar(Amizade amizade) {

        Amizade amizadeRetorno = serviceBuscarAmizadePorId.buscarPorId(amizade.getId());

        return amizadeRetorno;
    }
}
