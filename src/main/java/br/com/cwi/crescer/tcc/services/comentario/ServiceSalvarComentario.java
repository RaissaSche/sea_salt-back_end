package br.com.cwi.crescer.tcc.services.comentario;

import br.com.cwi.crescer.tcc.domains.Comentario;
import br.com.cwi.crescer.tcc.mappers.comentario.MapperSalvarComentario;
import br.com.cwi.crescer.tcc.repositories.RepositorioComentario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarComentario {

    @Autowired
    RepositorioComentario repositorio;

    @Autowired
    MapperSalvarComentario mapperSalvarComentario;

    public Comentario salvar(Comentario novoComentario, UserPrincipal user, Long idPostagem) {

        Comentario comentario = mapperSalvarComentario.map(novoComentario, user, idPostagem);

        Comentario comentarioRetorno = repositorio.save(comentario);

        return comentarioRetorno;
    }
}
