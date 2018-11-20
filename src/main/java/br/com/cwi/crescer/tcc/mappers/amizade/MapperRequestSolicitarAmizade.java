package br.com.cwi.crescer.tcc.mappers.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import br.com.cwi.crescer.tcc.requests.amizade.RequestSolicitarAmizade;
import br.com.cwi.crescer.tcc.services.amizade.ServiceBuscarAmizadePorIdDosAmigos;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestSolicitarAmizade {

    @Autowired
    RepositorioAmizade repositorio;

    @Autowired
    ServiceBuscarAmizadePorIdDosAmigos serviceBuscarAmizadePorIdDosAmigos;

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Amizade map(RequestSolicitarAmizade request) {

        Usuario usuarioLogado = serviceBuscarUsuarioPorId.buscarPorId(request.getIdUsuarioLogado());
        Usuario outroUsuario = serviceBuscarUsuarioPorId.buscarPorId(request.getIdOutroUsuario());
        Amizade amizadeRetorno = new Amizade();

        Amizade amizade = serviceBuscarAmizadePorIdDosAmigos.buscarPoridDosAmigos(usuarioLogado.getId(), outroUsuario.getId());

        if (amizade == null) {
            amizadeRetorno = new Amizade(usuarioLogado, outroUsuario, EnumStatusAmizades.SOLICITADO);
        } else {
            amizade.setStatus(EnumStatusAmizades.SOLICITADO);
            amizadeRetorno = repositorio.save(amizade);
        }

        return amizadeRetorno;
    }
}
