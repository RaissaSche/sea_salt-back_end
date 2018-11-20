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
class ServiceBuscarUsuarioPorEmailTest {

    @InjectMocks
    ServiceBuscarUsuarioPorEmail service;

    @Mock
    RepositorioUsuario repositorio;

    @Test
    void testeBuscarPorEmailEEncontrar() {

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail("abc@abc.com");
        Optional<Usuario> optionalUsuario = Optional.of(novoUsuario);

        Mockito.when(repositorio.findByEmail("abc@abc.com")).thenReturn(optionalUsuario);

        Usuario usuarioService = service.buscarPorEmail(novoUsuario.getEmail());

        assertEquals("abc@abc.com", usuarioService.getEmail());
    }

    @Test
    void testeBuscarPorEmailENaoEncontrar() {

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail("abc@abc.com");
        Optional<Usuario> optionalUsuario = Optional.of(novoUsuario);

        Mockito.when(repositorio.findByEmail("abc@abc.com")).thenReturn(Optional.empty());

        assertThrows(RegistroNaoEncontradoException.class, () -> {
            Usuario usuarioService = service.buscarPorEmail(novoUsuario.getEmail());
        });
    }
}