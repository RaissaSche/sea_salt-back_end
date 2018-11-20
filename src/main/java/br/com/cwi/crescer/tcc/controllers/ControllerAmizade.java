package br.com.cwi.crescer.tcc.controllers;

import br.com.cwi.crescer.tcc.domains.Amizade;
import br.com.cwi.crescer.tcc.mappers.amizade.MapperRequestAceitarAmizade;
import br.com.cwi.crescer.tcc.mappers.amizade.MapperRequestChecarStatusAmizade;
import br.com.cwi.crescer.tcc.mappers.amizade.MapperRequestDesfazerAmizade;
import br.com.cwi.crescer.tcc.mappers.amizade.MapperRequestSolicitarAmizade;
import br.com.cwi.crescer.tcc.requests.amizade.RequestAceitarAmizade;
import br.com.cwi.crescer.tcc.requests.amizade.RequestDesfazerAmizade;
import br.com.cwi.crescer.tcc.requests.amizade.RequestSolicitarAmizade;
import br.com.cwi.crescer.tcc.securities.UserPrincipal;
import br.com.cwi.crescer.tcc.services.amizade.*;
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
@RequestMapping("/amizades")
public class ControllerAmizade {

    @Autowired
    ServiceSolicitarAmizade serviceSolicitarAmizade;

    @Autowired
    ServiceAceitarAmizade serviceAceitarAmizade;

    @Autowired
    ServiceDesfazerAmizade serviceDesfazerAmizade;

    @Autowired
    MapperRequestSolicitarAmizade mapperRequestSolicitarAmizade;

    @Autowired
    MapperRequestAceitarAmizade mapperRequestAceitarAmizade;

    @Autowired
    MapperRequestDesfazerAmizade mapperRequestDesfazerAmizade;

    @Autowired
    ServiceBuscarAmizadePorId serviceBuscarAmizadePorId;

    @Autowired
    ServiceChecarStatusAmizade serviceChecarStatusAmizade;

    @Autowired
    MapperRequestChecarStatusAmizade mapperRequestChecarStatusAmizade;

    @Autowired
    ServiceBuscarAmigos serviceBuscarAmigos;

    @PostMapping()
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<Amizade> solicitar(
            @Valid @RequestBody RequestSolicitarAmizade request) {

        Amizade amizade = mapperRequestSolicitarAmizade.map(request);
        Amizade amizadeSolicitada = serviceSolicitarAmizade.solicitar(amizade);

        return ResponseEntity.status(HttpStatus.CREATED).body(amizadeSolicitada);
    }

    @PostMapping("/aceitar")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<Amizade> aceitar(
            @Valid @RequestBody RequestAceitarAmizade request) {

        Amizade amizade = mapperRequestAceitarAmizade.map(request);
        Amizade amizadeAceita = serviceAceitarAmizade.aceitar(amizade);

        return ResponseEntity.status(HttpStatus.CREATED).body(amizadeAceita);
    }

    @PostMapping("/desfazer")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<Amizade> desfazer(
            @Valid @RequestBody RequestDesfazerAmizade request) {

        Amizade amizade = mapperRequestDesfazerAmizade.map(request);
        Amizade amizadeDesfeita = serviceDesfazerAmizade.desfazer(amizade);

        return ResponseEntity.status(HttpStatus.CREATED).body(amizadeDesfeita);
    }

    @GetMapping("/amizade/{id}")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Amizade mostrarAmizadeId(@PathVariable("id") Long id) {

        Amizade amizade = serviceBuscarAmizadePorId.buscarPorId(id);

        return amizade;
    }

    @GetMapping("/amigos")
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public Page<Amizade> buscarAmigos(@PageableDefault(sort = "id") Pageable pageable,
                                      @AuthenticationPrincipal UserPrincipal user) {

        return serviceBuscarAmigos.buscarAmigos(pageable);
    }

    @GetMapping()
    @ApiResponses({@ApiResponse(code = 200, message = "Sucesso"), @ApiResponse(code = 400, message = "request inválido")})
    public ResponseEntity<Amizade> checarStatusAmizade(
            @RequestParam Long idLogado, @RequestParam Long idOutroUsuario) {

        Amizade amizade = mapperRequestChecarStatusAmizade.map(idLogado, idOutroUsuario);
        Amizade amizadeSolicitada = serviceChecarStatusAmizade.checar(amizade);

        return ResponseEntity.status(HttpStatus.CREATED).body(amizadeSolicitada);
    }
}
