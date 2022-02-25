package africa.semicolon.phoenixbookstore.security;

import africa.semicolon.phoenixbookstore.data.models.AppUser;
import africa.semicolon.phoenixbookstore.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RDBUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //query for user details from db
        AppUser user = userRepository.findByEmail(username).orElse(null);

        //check that user exists
        if(user == null) throw new UsernameNotFoundException("User with email " + username + " not found");

        //return userDetails
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());

    }

//    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities){
//        return  authorities.stream().map(
//                authority -> {
//                 return new SimpleGrantedAuthority(authority.name());
//                }).collect(Collectors.toList());
//    }
}
