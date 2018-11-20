package br.com.cwi.crescer.tcc.securities;

import br.com.cwi.crescer.tcc.domains.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
public class UserPrincipal implements UserDetails {

    private Long id;
    private String nomeCompleto;
    private String email;
    private String apelido;
    private LocalDate dataNascimento;
    private String senha;
    private String imagemPerfil;
    private Boolean ativo;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String nomeCompleto, String email, String apelido, LocalDate dataNascimento,
                         String senha, String imagemPerfil, Boolean ativo, Collection<? extends GrantedAuthority> authorities) {

        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.imagemPerfil = imagemPerfil;
        this.ativo = ativo;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Usuario usuario) {

        List<GrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority(/*pessoa.getPerfil().getRole()*/ "oi")
        );

        return new UserPrincipal(
                usuario.getId(),
                usuario.getNomeCompleto(),
                usuario.getEmail(),
                usuario.getApelido(),
                usuario.getDataNascimento(),
                usuario.getSenha(),
                usuario.getImagemPerfil(),
                true,
                authorities
        );
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return ativo;
    }

    @Override
    public boolean isAccountNonLocked() {
        return ativo;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }
}