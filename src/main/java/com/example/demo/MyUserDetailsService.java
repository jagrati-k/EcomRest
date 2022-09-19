package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.model.User;
import com.example.demo.service.UserDao;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=userDao.findByUsername(username);
        if(u==null)
            throw new UsernameNotFoundException("user not found!!");
        
        return new MyUserDetails(u);
    }
    
}
