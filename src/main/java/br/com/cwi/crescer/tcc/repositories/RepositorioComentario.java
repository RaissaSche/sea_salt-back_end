package br.com.cwi.crescer.tcc.repositories;

import br.com.cwi.crescer.tcc.domains.Comentario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RepositorioComentario extends PagingAndSortingRepository<Comentario, Long> {
}
