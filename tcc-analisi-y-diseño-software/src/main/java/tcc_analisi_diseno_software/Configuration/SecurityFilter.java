package tcc_analisi_diseno_software.Configuration;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tcc_analisi_diseno_software.Model.Repository.RepoUsuario;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final RepoUsuario repoUsuario;

    public SecurityFilter(TokenService tokenService, RepoUsuario repoUsuario) {
        this.tokenService = tokenService;
        this.repoUsuario = repoUsuario;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Obtener el token del encabezado
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            var token = authHeader.substring(7); // Extraer el token
            var nombreUsuario = tokenService.getSubject(token); // Obtener el nombre de usuario desde el token

            if (nombreUsuario != null) {
                var usuarioOptional = repoUsuario.findByUsername(nombreUsuario);

                if (usuarioOptional.isPresent()) {
                    var usuario = usuarioOptional.get();
                    var authentication = new UsernamePasswordAuthenticationToken(
                            usuario, null, usuario.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}

