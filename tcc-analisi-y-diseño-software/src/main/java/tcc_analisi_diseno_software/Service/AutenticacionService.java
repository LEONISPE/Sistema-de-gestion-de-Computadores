package tcc_analisi_diseno_software.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tcc_analisi_diseno_software.Model.Repository.RepoUsuario;

@Service
public class AutenticacionService implements UserDetailsService {

    private final RepoUsuario repoUsuario;

    public AutenticacionService(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repoUsuario.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}


