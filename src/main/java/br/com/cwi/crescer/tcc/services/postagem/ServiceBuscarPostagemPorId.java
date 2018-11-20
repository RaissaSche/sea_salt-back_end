package br.com.cwi.crescer.tcc.services.postagem;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.crescer.tcc.repositories.RepositorioPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarPostagemPorId {

    @Autowired
    RepositorioPostagem repositorio;

    public Postagem buscarPorId(Long id) {

        Postagem postagem = repositorio.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException(Usuario.class.getSimpleName()));

        return postagem;
    }
}
