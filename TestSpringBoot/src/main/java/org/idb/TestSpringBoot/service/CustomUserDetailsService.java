package org.idb.TestSpringBoot.service;

import lombok.AllArgsConstructor;
import org.idb.TestSpringBoot.entity.AppUserRole;
import org.idb.TestSpringBoot.entity.CustomUserDetails;
import org.idb.TestSpringBoot.entity.User;
import org.idb.TestSpringBoot.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo repo;

    private EmailValidator emailValidator;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String register(User user) {
        boolean isValied = emailValidator.test(user.getEmail());

        if (!isValied) {

            throw new IllegalStateException("Email is invalied");
        }
        return signUpuser(new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                AppUserRole.USER

        ));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email).get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public String signUpuser(User u) {
        boolean userExist = repo.findByEmail(u.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("Email Already Taken");
        }

//      String   encodedPassword=bCryptPasswordEncoder.encode(u.getPassword());
//
//        u.setPassword(encodedPassword);
//
        //Send Confirmation token

        return "work";
    }

}
