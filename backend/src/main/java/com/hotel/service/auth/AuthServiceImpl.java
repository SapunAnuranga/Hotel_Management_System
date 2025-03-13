package com.hotel.service.auth;

import com.hotel.dto.SignUpRequest;
import com.hotel.dto.UserDto;
import com.hotel.enums.UserRole;
import com.hotel.model.User;
import com.hotel.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount() {
        Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if (adminAccount.isEmpty()) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setPassword("admin");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
            System.out.println("admin account created successfully");

        }else {
            System.out.println("Admin account already exists");
        }
    }

    public UserDto createUser(SignUpRequest signUpRequest) {
        if (userRepository.findFirstByEmail(signUpRequest.getEmail()).isPresent()) {
            throw new EntityExistsException("User already present with email: " + signUpRequest.getEmail());
        }

        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setName(signUpRequest.getName());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        User createdUser = userRepository.save(user);

        return createdUser.getUserDto();
    }

}
