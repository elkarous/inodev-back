package com.brightcoding.app.ws.social;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brightcoding.app.ws.entities.CondidatEntity;
import com.brightcoding.app.ws.repositories.CondidatRepository;

@RestController
public class UserController1 {

    @Autowired
    private CondidatRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public CondidatEntity getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
       CondidatEntity user= userRepository.findById(userPrincipal.getId());
     if (user==null)
     throw	new ResourceNotFoundException("User", "id", userPrincipal.getId());
	return user;

}
}