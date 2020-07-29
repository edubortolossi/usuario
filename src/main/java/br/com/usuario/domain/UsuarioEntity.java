package br.com.usuario.domain;

import br.com.usuario.enums.Time;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class UsuarioEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Time time;

    private String email;

    private LocalDate dataNascimento;

    public UsuarioEntity( Long id, String nome, Time time, String email, LocalDate dataNascimento ) {
        this.id = id;
        this.nome = nome;
        this.time = time;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioEntity() {}
}
