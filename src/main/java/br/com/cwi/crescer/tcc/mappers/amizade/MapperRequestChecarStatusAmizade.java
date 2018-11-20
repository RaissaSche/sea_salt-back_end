package br.com.cwi.crescer.tcc.mappers.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.services.amizade.ServiceBuscarAmizadePorIdDosAmigos;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestChecarStatusAmizade {

    @Autowired
    ServiceBuscarAmizadePorIdDosAmigos serviceBuscarAmizadePorIdDosAmigos;

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Amizade map(Long idLogado, Long idOutroUsuario) {

        Amizade amizade = serviceBuscarAmizadePorIdDosAmigos.buscarPoridDosAmigos(idLogado, idOutroUsuario);
        Usuario usuarioLogado = serviceBuscarUsuarioPorId.buscarPorId(idLogado);
        Usuario outroUsuario = serviceBuscarUsuarioPorId.buscarPorId(idOutroUsuario);

        amizade.setUsuarioA(usuarioLogado);
        amizade.setUsuarioB(outroUsuario);

        return amizade;
    }
}
