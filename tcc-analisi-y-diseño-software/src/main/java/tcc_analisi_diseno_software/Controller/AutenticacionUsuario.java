package tcc_analisi_diseno_software.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tcc_analisi_diseno_software.Configuration.DatosJwtToken;
import tcc_analisi_diseno_software.Configuration.TokenService;
import tcc_analisi_diseno_software.Model.Entities.CredencialesUsuario;
import tcc_analisi_diseno_software.Model.Entities.Usuario;

@RestController
@RequestMapping("/login")
public class AutenticacionUsuario {


    private final AuthenticationManager authenticationManager;
    private final TokenService tokenservice;

    public AutenticacionUsuario(AuthenticationManager authenticationManager, TokenService tokenservice) {
        this.authenticationManager = authenticationManager;
        this.tokenservice = tokenservice;
    }

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid CredencialesUsuario credencialesUsuario) {
        Authentication Authtoken = new UsernamePasswordAuthenticationToken(credencialesUsuario.username(),
                credencialesUsuario.password());
        var UsusarioAutenticado = authenticationManager.authenticate(Authtoken);
        var JWTtoken = tokenservice.generarToken((Usuario) UsusarioAutenticado.getPrincipal());
        return ResponseEntity.ok( new DatosJwtToken(JWTtoken));

    }
}
