package br.com.cwi.crescer.tcc.services.usuario;

import br.com.cwi.crescer.tcc.requests.usuario.RequestLogarUsuario;
import br.com.cwi.crescer.tcc.securities.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLogarUsuario {

    @Autowired
    AuthenticationService authenticationService;

    public String logar(RequestLogarUsuario request) {

        String email = request.getEmail();
        String senha = request.getSenha();
        String token = authenticationService.authenticate(email, senha);

        return token;
    }
}
