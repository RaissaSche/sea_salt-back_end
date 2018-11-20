package br.com.cwi.crescer.tcc.mappers.comentario;

import br.com.cwi.crescer.tcc.domains.Comentario;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import br.com.cwi.crescer.tcc.services.postagem.ServiceBuscarPostagemPorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperSalvarComentario {

    @Autowired
    ServiceBuscarPostagemPorId serviceBuscarPostagemPorId;

    public Comentario map(Comentario novoComentario, UserPrincipal user, Long idPostagem) {

        novoComentario.setPostagem(serviceBuscarPostagemPorId.buscarPorId(idPostagem));
        Usuario usuario = new Usuario(
                user.getNomeCompleto(),
                user.getEmail(),
                user.getApelido(),
                user.getDataNascimento(),
                user.getSenha(),
                user.getImagemPerfil());
        novoComentario.setUsuario(usuario);

        return novoComentario;
    }
}
