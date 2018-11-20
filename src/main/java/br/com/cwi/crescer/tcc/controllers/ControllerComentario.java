package br.com.cwi.crescer.tcc.controllers;

import br.com.cwi.crescer.tcc.domains.Comentario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import br.com.cwi.crescer.tcc.services.comentario.ServiceSalvarComentario;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comentarios")
public class ControllerComentario {

    @Autowired
    ServiceSalvarComentario serviceSalvarComentario;

    @PostMapping("/{idPostagem}")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<Comentario> salvar(@AuthenticationPrincipal UserPrincipal user,
                                             @Valid @RequestBody Comentario comentario, @PathVariable("idPostagem") Long idPostagem) {

        Comentario comentarioSalvo = serviceSalvarComentario.salvar(comentario, user, idPostagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioSalvo);
    }
}
