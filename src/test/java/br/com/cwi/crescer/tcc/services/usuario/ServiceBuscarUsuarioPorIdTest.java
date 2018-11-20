package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.exceptions.RegistroNaoEncontradoException;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ServiceBuscarUsuarioPorIdTest {

    @InjectMocks
    ServiceBuscarUsuarioPorId service;

    @Mock
    RepositorioUsuario repositorio;

    @Test
    void testeBuscarPorIdEEncontrar() {

        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(new Long(1));
        Optional<Usuario> optionalUsuario = Optional.of(novoUsuario);

        Mockito.when(repositorio.findById(new Long(1))).thenReturn(optionalUsuario);

        Usuario usuarioService = service.buscarPorId(novoUsuario.getId());

        assertEquals(new Long(1), usuarioService.getId());
    }

    @Test
    void testeBuscarPorIdENaoEncontrar() {

        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(new Long(1));
        Optional<Usuario> optionalUsuario = Optional.of(novoUsuario);

        Mockito.when(repositorio.findById(new Long(1))).thenReturn(Optional.empty());

        assertThrows(RegistroNaoEncontradoException.class, () -> {
            Usuario usuarioService = service.buscarPorId(novoUsuario.getId());
        });
    }
}