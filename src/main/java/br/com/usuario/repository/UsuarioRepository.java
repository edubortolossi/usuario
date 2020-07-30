package br.com.usuario.repository;

import br.com.usuario.domain.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository< UsuarioEntity, Long > {
    List< UsuarioEntity > findByEmail( String email );
}
