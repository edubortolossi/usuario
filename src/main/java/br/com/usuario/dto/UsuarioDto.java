package br.com.usuario.dto;

import br.com.usuario.enums.Time;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@ApiModel( value = "usuario", description = "Data transfer from user" )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class UsuarioDto {

    @ApiModelProperty( required = true )
    @NotBlank( message = "{required.field}" )
    private String nome;

    @NotNull( message = "{required.field}" )
    @ApiModelProperty( allowableValues = "ATHLETICO_PARANAENSE,ATLETICO_GOIANIENSE, ATLETICO_MINEIRO"
            + "BAHIA, BOTAFOGO, CEARA, CORINTHIANS, CORITIBA, FLAMENGO, FLUMINENSE, FORTALEZA"
            + "GOIAS, GREMIO, INTERNACIONAL, PALMEIRAS, RED_BULL, SANTOS, SAO_PAULO, SPORT, VASCO" )
    private Time time;

    @NotBlank(message = "{required.field}")
    private String email;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @NotBlank(message = "{required.field}")
    private String dataNascimento;

}
