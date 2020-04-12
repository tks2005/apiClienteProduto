package com.entrevista.config;

import com.entrevista.model.User;
import com.entrevista.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userName + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                getAuthorities(user));

        /*String senha;
        if (userName.equalsIgnoreCase("admin"))
            senha = "$2y$12$NuWcrkMufOIKvPUOKbY52urB54alxh7oB775Q8i.J2fR936fwRB8a";
        else
            senha = "$2y$12$/hY/tdnj0hlTP2q5seFblOCerySJW3dmZ9X5f0vNn5zKC58XOgi6C";

        return new org.springframework.security.core.userdetails.User(userName, senha,
                getAuthorities(userName));*/
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {

        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;

        /*List<String> permissoes = new ArrayList<String>();

        String senha;
        if (userName.equalsIgnoreCase("admin")) {
            permissoes.add("ROLE_USER");
            permissoes.add("ROLE_ADMIN");
        }
        else
            permissoes.add("ROLE_USER");

        String[] userRoles = permissoes.stream().toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);

        return authorities;*/
    }
}
