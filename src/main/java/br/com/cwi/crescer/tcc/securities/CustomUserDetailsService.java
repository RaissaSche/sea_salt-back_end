package br.com.cwi.crescer.tcc.securities;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

/*
 * Service para obter dados do usuário no contexto de autenticação
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Usuario usuario = getUser(() -> repositorioUsuario.findByEmail(username));

        return br.com.cwi.crescer.tcc.securities.UserPrincipal.create(usuario);
    }

    public UserDetails loadUserById(Long id) {

        Usuario usuario = getUser(() -> repositorioUsuario.findById(id));

        return br.com.cwi.crescer.tcc.securities.UserPrincipal.create(usuario);
    }

    private Usuario getUser(Supplier<Optional<Usuario>> supplier) {

        return supplier.get().orElseThrow(() ->
                new UsernameNotFoundException("Usuário não cadastrado")
        );
    }
}
