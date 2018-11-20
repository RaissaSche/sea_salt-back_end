package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarAmigos {

    @Autowired
    RepositorioAmizade repositorio;

    public Page<Amizade> buscarAmigos(Pageable pageable) {

        Page<Amizade> page = repositorio.findByStatus(pageable, EnumStatusAmizades.AMIGOS);

        return page;
    }
}
