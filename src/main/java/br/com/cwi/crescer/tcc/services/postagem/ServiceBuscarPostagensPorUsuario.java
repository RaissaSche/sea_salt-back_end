package br.com.cwi.crescer.tcc.services.postagem;


import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.crescer.tcc.repositories.RepositorioPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarPostagensPorUsuario {

    @Autowired
    RepositorioPostagem repositorio;

    public Page<Postagem> buscarPorUsuario(Usuario usuario, Pageable pageable) {

        Page<Postagem> pages = repositorio.findAllByUsuario(usuario, pageable);

        if (pages.getSize() == 0) {
            throw new RegistroNaoEncontradoException(Usuario.class.getSimpleName());
        }

        return pages;
    }
}
