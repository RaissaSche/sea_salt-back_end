package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.DTOs.DTOPageUsuarioComSatusAmizade;
import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
import br.com.cwi.crescer.tcc.repositories.RepositorioAmizade;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicePesquisarUsuarioPorNomeEEmail {

    @Autowired
    RepositorioUsuario repositorio;

    @Autowired
    RepositorioAmizade repositorioAmizade;

    //TODO: Resolver isso pela query
    public Page<DTOPageUsuarioComSatusAmizade> buscarPorNomeEEmail(String nomeOuEmail, Pageable pageable, UserPrincipal user) {

        Page<Usuario> page = repositorio.findByNomeCompletoContainsIgnoreCaseOrEmailContainsIgnoreCase(
                nomeOuEmail, nomeOuEmail, pageable);

        Page<DTOPageUsuarioComSatusAmizade> pageUsuarioComSatusAmizades = page.map(
                (u -> this.convertToDTOPageUsuarioComSatusAmizade(user, u)));

        return pageUsuarioComSatusAmizades;
    }

    private DTOPageUsuarioComSatusAmizade convertToDTOPageUsuarioComSatusAmizade(UserPrincipal userPrincipal, Usuario usuario) {

        DTOPageUsuarioComSatusAmizade pageUsuarioComSatusAmizade = new DTOPageUsuarioComSatusAmizade(
                usuario,
                getStatusAmizade(userPrincipal, usuario)
        );
        return pageUsuarioComSatusAmizade;
    }

    private EnumStatusAmizades getStatusAmizade(UserPrincipal userPrincipal, Usuario outroUsuario) {

        Optional<Amizade> amizade = repositorioAmizade.findByUsuarioAAndusuarioB(
                userPrincipal.getId(),
                outroUsuario.getId());

        if (amizade.isPresent()) {
            return amizade.get().getStatus();
        } else {
            return EnumStatusAmizades.DESCONHECIDOS;
        }
    }
}
