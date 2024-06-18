package com.fitflow.api.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                email,
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        List<String> privileges = getPrivileges(roles);
        return getGrantedAuthorities(privileges);
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();

        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }

        for (Privilege item : collection) {
            privileges.add(item.getName());
        }

        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }

        return authorities;
    }
}
