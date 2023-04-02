package com.spring.security;

import com.spring.security.entity.Role;
import com.spring.security.entity.User;
import com.spring.security.repository.RoleRepository;
import com.spring.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        loadRoles();
        loadUsers();
    }

    private void loadRoles() {
        Role adminRole = new Role();
        adminRole.setId(1L);
        adminRole.setName("ADMIN");

        Role userRole = new Role();
        userRole.setId(2L);
        userRole.setName("USER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);
    }

    private void loadUsers() {
        Role adminRole = roleRepository.findByName("ADMIN");
        Role userRole = roleRepository.findByName("USER");

        User admin = new User();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("1234"));
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setEnabled(true);
        admin.setCredentialsNonExpired(true);
        Set<Role>aroles=new HashSet<>();
        aroles.add(adminRole);
        admin.setRoles(aroles);




        User user = new User();
        user.setId(2L);
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        Set<Role>uroles=new HashSet<>();
        uroles.add(userRole);
        user.setRoles(uroles);



        userRepository.save(admin);
        userRepository.save(user);
    }

}