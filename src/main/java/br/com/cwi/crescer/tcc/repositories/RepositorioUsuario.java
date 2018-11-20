package br.com.cwi.crescer.tcc.repositories;

import br.com.cwi.crescer.tcc.domains.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RepositorioUsuario extends PagingAndSortingRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);

    Page<Usuario> findByNomeCompletoContainsIgnoreCaseOrEmailContainsIgnoreCase(
            String nome, String email, Pageable pageable);
}
