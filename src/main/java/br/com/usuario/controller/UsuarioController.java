package br.com.usuario.controller;

import br.com.usuario.dto.UsuarioDto;
import br.com.usuario.dto.UsuarioResponse;
import br.com.usuario.exception.BusinessException;
import br.com.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Set;

@RestController
@RequestMapping( value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE )
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity< Long > salvar( @Valid @RequestBody UsuarioDto usuario ) throws Exception {
        return ResponseEntity.status( HttpStatus.CREATED ).body( usuarioService.salvar( usuario ) );
    }

    @DeleteMapping( value = "/{id}" )
    public ResponseEntity< String > deletar( @PathVariable( value = "id" ) Long id ) throws Exception {

        usuarioService.deletar( id );

        return ResponseEntity.ok( "Usuario deletado com sucesso" );
    }

    @PutMapping( value = "/{id}" )
    public ResponseEntity< UsuarioResponse > alterar( @PathVariable( value = "id" ) Long id, @Valid @RequestBody UsuarioDto usuario ) throws ParseException, BusinessException, BusinessException {
        return ResponseEntity.ok( usuarioService.alterar( id, usuario ) );
    }

    @GetMapping
    public ResponseEntity< Set< UsuarioResponse > > listar() {
        return ResponseEntity.ok( usuarioService.listar() );
    }
}
