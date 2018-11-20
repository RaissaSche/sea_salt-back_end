package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.requests.usuario.RequestLogarUsuario;
import br.com.cwi.crescer.tcc.securities.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ServiceLogarUsuarioTest {

    @InjectMocks
    ServiceLogarUsuario service;

    @Mock
    AuthenticationService authenticationService;

    @Test
    void testeLogarUsuario() {

        RequestLogarUsuario request = new RequestLogarUsuario("123", "abc");

        Mockito.when(authenticationService.authenticate("123", "abc"))
                .thenReturn("token");

        String token = service.logar(request);

        assertEquals(token, "token");
    }
}