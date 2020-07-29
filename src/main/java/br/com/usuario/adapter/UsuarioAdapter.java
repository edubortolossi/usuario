package br.com.usuario.adapter;

import br.com.usuario.domain.UsuarioEntity;
import br.com.usuario.dto.UsuarioDto;
import br.com.usuario.dto.UsuarioResponse;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioAdapter {

    public static UsuarioEntity requestToDomain( UsuarioDto usuarioDto, LocalDate dataNascimento ) throws ParseException {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );

        return UsuarioEntity.builder()
                .nome( usuarioDto.getNome() )
                .time( usuarioDto.getTime() )
                .email( usuarioDto.getEmail() )
                .dataNascimento( LocalDate.parse( usuarioDto.getDataNascimento(), parser ) )
                .build();
    }

    public static UsuarioEntity requestToDomain( UsuarioDto usuarioDto ) throws ParseException {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
        return UsuarioEntity.builder()
                .nome( usuarioDto.getNome() )
                .time( usuarioDto.getTime() )
                .email( usuarioDto.getEmail() )
                .dataNascimento( LocalDate.parse( usuarioDto.getDataNascimento(), parser ) )
                .build();
    }

    public static UsuarioResponse domainToResponse( UsuarioEntity usuarioEntity ) throws ParseException {
        return UsuarioResponse.builder()
                .nome( usuarioEntity.getNome() )
                .time( usuarioEntity.getTime() )
                .email( usuarioEntity.getEmail() )
                .dataNascimento( usuarioEntity.getDataNascimento().toString() )
                .build();
    }

}
