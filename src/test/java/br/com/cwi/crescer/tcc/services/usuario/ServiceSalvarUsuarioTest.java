package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.repositories.RepositorioUsuario;
import br.com.cwi.crescer.tcc.validators.ValidatorEmailNaoRepetido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class ServiceSalvarUsuarioTest {

    @InjectMocks
    ServiceSalvarUsuario service;

    @Mock
    RepositorioUsuario repositorio;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    ValidatorEmailNaoRepetido validator;

    @Captor
    ArgumentCaptor<Usuario> usuarioArgumentCaptor;

    @Test
    void testeSalvarUsuario() {

        Usuario novoUsuario = new Usuario();
        Usuario usuarioSave = new Usuario();
        novoUsuario.setSenha("abc");

        Mockito.when(passwordEncoder.encode("abc")).thenReturn("123");
        Mockito.when(repositorio.save(novoUsuario)).thenReturn(usuarioSave);

        Usuario usuarioService = service.salvar(novoUsuario);

        Mockito.verify(validator, times(1)).accept(novoUsuario);
        Mockito.verify(repositorio, times(1)).save(usuarioArgumentCaptor.capture());
        Usuario u = usuarioArgumentCaptor.getValue();

        assertEquals("123", u.getSenha());
        assertEquals(usuarioService, usuarioSave);
    }
}