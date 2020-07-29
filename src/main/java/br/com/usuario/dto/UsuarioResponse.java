package br.com.usuario.dto;

import br.com.usuario.enums.Time;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {

    private String nome;

    private Time time;

    private String email;

    private String dataNascimento;
}
