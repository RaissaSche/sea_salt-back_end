package br.com.cwi.crescer.tcc.repositories;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RepositorioAmizade extends PagingAndSortingRepository<Amizade, Long> {

    @Query("SELECT a FROM Amizade a " +
            "WHERE (a.usuarioA.id = ?1 AND a.usuarioB.id = ?2) OR" +
            "(a.usuarioB.id = ?1 AND a.usuarioA.id = ?2)")
    Optional<Amizade> findByUsuarioAAndusuarioB(Long idLogado, Long idOutroUsuario);

    Page<Amizade> findByStatus(Pageable pageable, EnumStatusAmizades status);
}
