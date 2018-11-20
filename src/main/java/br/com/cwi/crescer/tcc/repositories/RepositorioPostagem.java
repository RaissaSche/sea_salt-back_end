package br.com.cwi.crescer.tcc.repositories;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositorioPostagem extends PagingAndSortingRepository<Postagem, Long> {

    Page<Postagem> findAllByUsuario(Usuario usuario, Pageable pageable);

    Page<Postagem> findAllByIsPublic(String isPublic, Pageable pageable);
}
