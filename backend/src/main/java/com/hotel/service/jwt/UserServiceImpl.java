package com.hotel.service.jwt;

import com.hotel.model.User;
import com.hotel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService getUserDetailsService() {
        return username -> {
            User user = userRepository.findFirstByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
            return user;
        };
    }
}
