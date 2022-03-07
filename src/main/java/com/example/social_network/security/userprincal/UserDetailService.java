package com.example.social_network.security.userprincal;

import com.example.social_network.model.User;
import com.example.social_network.ropository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found -> username or pass" + username));
        return UserPrinciple.build(user);
    }
}
