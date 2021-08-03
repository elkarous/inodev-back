package com.brightcoding.app.ws.social;

import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.repositories.CondidatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    CondidatRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	CondidatEntity user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
    	CondidatEntity user = userRepository.findById(id);
    	if (user==null)
    		throw	new ResourceNotFoundException("User", "id", id);
       
        return UserPrincipal.create(user);
    }
}
