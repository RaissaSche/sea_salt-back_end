package br.com.cwi.crescer.tcc.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "seq", sequenceName = "SEQ_POSTAGEM", initialValue = 1, allocationSize = 1)
public class Postagem extends Dominio {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String titulo;
    private String texto;
    private String imagem;
    private Integer contadorGostei;
    private Integer contadorComentarios;
    private String isPublic;
}
