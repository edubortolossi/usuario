package br.com.usuario.service;

import br.com.usuario.adapter.UsuarioAdapter;
import br.com.usuario.domain.UsuarioEntity;
import br.com.usuario.dto.UsuarioDto;
import br.com.usuario.dto.UsuarioResponse;
import br.com.usuario.exception.BusinessException;
import br.com.usuario.repository.UsuarioRepository;
import jdk.nashorn.internal.runtime.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    DateTimeFormatter parser = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );

    public Long salvar( UsuarioDto usuarioDto ) throws Exception {
        return usuarioRepository.save( UsuarioAdapter.requestToDomain( usuarioDto ) ).getId();
    }

    public void deletar( Long id ) throws Exception {
        final Optional< UsuarioEntity > opUsuario = usuarioRepository.findById( id );
        if( !opUsuario.isPresent() ) {
            throw new BusinessException( "Usuario não foi encontrado", "" );
        }
        usuarioRepository.delete( opUsuario.get() );
    }

    public UsuarioResponse alterar( Long idUsuario, UsuarioDto usuarioDto ) throws BusinessException, ParseException {
        final UsuarioEntity usuarioEntity = UsuarioAdapter.requestToDomain( usuarioDto );
        usuarioEntity.setId( idUsuario );
        usuarioRepository.save( usuarioEntity );

        return UsuarioAdapter.domainToResponse( usuarioEntity );
    }

    public Set< UsuarioResponse > listar() {
        final Iterable< UsuarioEntity > campanhas = usuarioRepository.findAll();
        Set< UsuarioResponse > responses = new LinkedHashSet< UsuarioResponse >();
        campanhas.forEach( r -> {
            UsuarioResponse response = null;
            try {
                response = UsuarioAdapter.domainToResponse( r );
            } catch( ParseException e ) {
                throw new ParserException( "Erro ao converter datas" );
            }
            responses.add( response );
        } );
        return responses;
    }
}
