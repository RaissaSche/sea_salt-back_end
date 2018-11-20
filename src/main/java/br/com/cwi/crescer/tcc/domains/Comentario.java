package br.com.cwi.crescer.tcc.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "seq", sequenceName = "SEQ_COMENTARIO", initialValue = 1, allocationSize = 1)
public class Comentario extends Dominio {

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;
    private String texto;
}
