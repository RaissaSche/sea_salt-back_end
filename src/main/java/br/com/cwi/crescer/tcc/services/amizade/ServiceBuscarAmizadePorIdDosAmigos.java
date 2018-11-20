package br.com.cwi.crescer.tcc.services.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarAmizadePorIdDosAmigos {

    @Autowired
    RepositorioAmizade repositorio;

    public Amizade buscarPoridDosAmigos(Long idLogado, Long idOutrousuario) {

        Amizade amizade = repositorio.findByUsuarioAAndusuarioB(idLogado, idOutrousuario)
                .orElseThrow(() -> new RegistroNaoEncontradoException(Usuario.class.getSimpleName()));

        return amizade;
    }
}
