package br.com.cwi.crescer.tcc.securities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/*
 * Service para iniciar um novo processo de autenticação
 * */

@Service
public class AuthenticationService {

    private static final String headerPrefix = "Bearer ";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private br.com.cwi.crescer.tcc.securities.JwtTokenProvider jwtTokenProvider;

    public String authenticate(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return headerPrefix + jwtTokenProvider.generateToken(authentication);
    }
}
