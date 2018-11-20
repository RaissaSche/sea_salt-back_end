package br.com.cwi.crescer.tcc.mappers.amizade;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.requests.amizade.RequestDesfazerAmizade;
import br.com.cwi.crescer.tcc.services.amizade.ServiceBuscarAmizadePorIdDosAmigos;
import br.com.cwi.crescer.tcc.services.usuario.ServiceBuscarUsuarioPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperRequestDesfazerAmizade {

    @Autowired
    ServiceBuscarAmizadePorIdDosAmigos serviceBuscarAmizadePorIdDosAmigos;

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    public Amizade map(RequestDesfazerAmizade request) {

        Amizade amizade = serviceBuscarAmizadePorIdDosAmigos.buscarPoridDosAmigos(
                request.getIdUsuarioLogado(), request.getIdOutroUsuario());
        Usuario usuarioLogado = serviceBuscarUsuarioPorId.buscarPorId(request.getIdUsuarioLogado());
        Usuario outroUsuario = serviceBuscarUsuarioPorId.buscarPorId(request.getIdOutroUsuario());

        amizade.setUsuarioA(usuarioLogado);
        amizade.setUsuarioB(outroUsuario);

        return amizade;
    }
}
