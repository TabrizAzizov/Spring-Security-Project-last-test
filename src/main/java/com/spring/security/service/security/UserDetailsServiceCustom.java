package com.spring.security.service.security;

import com.spring.security.entity.User;
import com.spring.security.exception.BaseException;
import com.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;

import java.util.stream.Collectors;

public class UserDetailsServiceCustom implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailCustom userDetailCustom=getUserDetailsCustom(username);

        if (ObjectUtils.isEmpty(userDetailCustom)){
            throw new UsernameNotFoundException("user not found");
        }
        return userDetailCustom;
    }

    private UserDetailCustom getUserDetailsCustom(String username){
        User user=userRepository.findByUsername(username);

        if (ObjectUtils.isEmpty(user)){
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST),"user not found");

        }

        return new UserDetailCustom(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(r-> new SimpleGrantedAuthority(r.getName()))
                        .collect(Collectors.toList()),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired()
        );
    }
}
