package br.com.cwi.crescer.tcc.controllers;

import br.com.cwi.crescer.tcc.domains.Postagem;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.mappers.postagem.MapperRequestBuscarPostagensUsuario;
import br.com.cwi.crescer.tcc.mappers.postagem.MapperRequestSalvarPostagem;
import br.com.cwi.crescer.tcc.mappers.postagem.MapperResponseSalvarPostagem;
import br.com.cwi.crescer.tcc.requests.postagem.RequestSalvarPostagem;
import br.com.cwi.crescer.tcc.responses.postagem.ResponseSalvarPostagem;
import br.com.cwi.crescer.tcc.services.postagem.ServiceBuscarPostagensPorUsuario;
import br.com.cwi.crescer.tcc.services.postagem.ServiceSalvarPostagem;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/postagens")
public class ControllerPostagem {

    @Autowired
    ServiceSalvarPostagem serviceSalvarPostagem;

    @Autowired
    MapperRequestSalvarPostagem mapperRequestSalvarPostagem;

    @Autowired
    MapperResponseSalvarPostagem mapperResponseSalvarPostagem;

    @Autowired
    ServiceBuscarPostagensPorUsuario serviceBuscarPostagensPorUsuario;

    @Autowired
    MapperRequestBuscarPostagensUsuario mapperRequestBuscarPostagensUsuario;

    @PostMapping("/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<ResponseSalvarPostagem> salvar(
            @PathVariable("id") Long idUsuario,
            @Valid @RequestBody RequestSalvarPostagem request) {

        Postagem postagem = mapperRequestSalvarPostagem.map(request);
        Postagem postagemSalva = serviceSalvarPostagem.salvar(postagem);
        ResponseSalvarPostagem response = mapperResponseSalvarPostagem.map(postagemSalva);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Page<Postagem> mostrarpostagensUsuario(@PathVariable("id") Long id,
                                                  @PageableDefault Pageable pageable) {

        Usuario usuario = mapperRequestBuscarPostagensUsuario.map(id);
        Page<Postagem> pages = serviceBuscarPostagensPorUsuario.buscarPorUsuario(usuario, pageable);

        return pages;
    }
}
