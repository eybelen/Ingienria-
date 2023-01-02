package com.xavia.ris.Security;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xavia.ris.Entidades.Usuario;
import com.xavia.ris.Servicio.IUsuarioServicio;

@Service
public class UserDetailsI implements UserDetailsService {

    @Autowired
    IUsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            List<GrantedAuthority> role = new LinkedList<>();
            role.add(new SimpleGrantedAuthority("ROLE_ADMINISTRADOR"));
            return new User(username, "1234", role);
        } else {
            Usuario privote = usuarioServicio.getByUsername(username);
            List<GrantedAuthority> role = new LinkedList<>();
            role.add(new SimpleGrantedAuthority(("ROLE_"+privote.getRol()).toUpperCase()));
            return new User(privote.getUsername(), privote.getPassword(), role);
        }
    }

}
