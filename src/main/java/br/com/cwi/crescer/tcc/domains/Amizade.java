package br.com.cwi.crescer.tcc.domains;

import br.com.cwi.crescer.tcc.enums.EnumStatusAmizades;
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
@SequenceGenerator(name = "seq", sequenceName = "SEQ_AMIZADE", initialValue = 1, allocationSize = 1)
public class Amizade extends Dominio {

    @ManyToOne
    @JoinColumn(name = "id_usuario_A")
    private Usuario usuarioA;
    @ManyToOne
    @JoinColumn(name = "id_usuario_B")
    private Usuario usuarioB;
    @Enumerated(EnumType.STRING)
    private EnumStatusAmizades status;

    public Amizade(Usuario usuarioA, Usuario usuarioB) {
        this.usuarioA = usuarioA;
        this.usuarioB = usuarioB;
        this.status = EnumStatusAmizades.DESCONHECIDOS;
    }
}
