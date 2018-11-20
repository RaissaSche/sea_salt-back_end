package br.com.cwi.crescer.tcc.controllers;

import br.com.cwi.crescer.tcc.DTOs.DTOPageUsuarioComSatusAmizade;
import br.com.cwi.crescer.tcc.domains.Usuario;
import br.com.cwi.crescer.tcc.mappers.usuario.MapperRequestEditarUsuario;
import br.com.cwi.crescer.tcc.mappers.usuario.MapperRequestSalvarUsuario;
import br.com.cwi.crescer.tcc.mappers.usuario.MapperResponseEditarUsuario;
import br.com.cwi.crescer.tcc.mappers.usuario.MapperResponseSalvarUsuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestEditarUsuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestLogarUsuario;
import br.com.cwi.crescer.tcc.requests.usuario.RequestSalvarUsuario;
import br.com.cwi.crescer.tcc.responses.usuario.ResponseEditarUsuario;
import br.com.cwi.crescer.tcc.responses.usuario.ResponseSalvarUsuario;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import br.com.cwi.crescer.tcc.services.usuario.*;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    ServiceSalvarUsuario serviceSalvarUsuario;

    @Autowired
    ServiceEditarUsuario serviceEditarUsuario;

    @Autowired
    ServiceLogarUsuario serviceLogarUsuario;

    @Autowired
    ServiceBuscarUsuarios serviceBuscarUsuarios;

    @Autowired
    ServiceBuscarUsuarioLogado serviceBuscarUsuarioLogado;

    @Autowired
    ServiceBuscarUsuarioPorId serviceBuscarUsuarioPorId;

    @Autowired
    ServicePesquisarUsuarioPorNomeEEmail servicePesquisarUsuarioPorNomeEEmail;

    @Autowired
    MapperRequestEditarUsuario mapperRequest;

    @Autowired
    MapperResponseEditarUsuario mapperResponse;

    @PostMapping()
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<ResponseSalvarUsuario> salvarUsuario(
            @RequestBody @Valid RequestSalvarUsuario request) {

        MapperRequestSalvarUsuario mapperRequest = new MapperRequestSalvarUsuario();
        MapperResponseSalvarUsuario mapperResponse = new MapperResponseSalvarUsuario();
        Usuario usuario = mapperRequest.map(request);
        Usuario usuarioSalvo = serviceSalvarUsuario.salvar(usuario);
        ResponseSalvarUsuario response = mapperResponse.map(usuarioSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/editar")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<ResponseEditarUsuario> editarUsuario(@AuthenticationPrincipal UserPrincipal user,
                                                               @RequestBody @Valid RequestEditarUsuario request) {
        Usuario usuario = mapperRequest.map(request, user);
        Usuario usuarioEditado = serviceEditarUsuario.editar(usuario);
        ResponseEditarUsuario response = mapperResponse.map(usuarioEditado);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public String logar(@RequestBody @Valid RequestLogarUsuario request) {

        String token = serviceLogarUsuario.logar(request);

        return token;
    }

    @GetMapping
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Page<Usuario> buscarUsuarios(@PageableDefault(sort = "id") Pageable pageable) {

        return serviceBuscarUsuarios.buscarUsuarios(pageable);
    }

    @GetMapping("/logado")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Usuario buscarUsuarioLogado(@AuthenticationPrincipal UserPrincipal user) {

        return serviceBuscarUsuarioLogado.buscarUsuarioLogado(user);
    }

    @GetMapping("/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Usuario mostrarUsuarioId(@PathVariable("id") Long id) {

        Usuario usuario = serviceBuscarUsuarioPorId.buscarPorId(id);

        return usuario;
    }

    @GetMapping("/pesquisar")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Page<DTOPageUsuarioComSatusAmizade> pesquisarUsuario(String nome, String nomeOuEmail, @PageableDefault Pageable pageable,
                                                                @AuthenticationPrincipal UserPrincipal user) {

        return servicePesquisarUsuarioPorNomeEEmail.buscarPorNomeEEmail(nomeOuEmail, pageable, user);
    }
}
