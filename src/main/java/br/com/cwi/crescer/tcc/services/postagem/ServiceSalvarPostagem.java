package br.com.cwi.crescer.tcc.services.postagem;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.repositories.RepositorioPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSalvarPostagem {

    @Autowired
    RepositorioPostagem repositorio;

    public Postagem salvar(Postagem novaPostagem) {

        Postagem postagemRetorno = repositorio.save(novaPostagem);

        return postagemRetorno;
    }
}
