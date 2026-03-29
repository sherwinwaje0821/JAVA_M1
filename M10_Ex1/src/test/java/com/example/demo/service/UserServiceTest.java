package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("john");
        user.setPassword("password123");
    }

    // ✅ SUCCESS CASE
    @Test
    void createUser_success() {
        when(userRepository.existsByUsername("john")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = userService.createUser("john", "password123");

        assertNotNull(result);
        assertEquals("john", result.getUsername());
        verify(userRepository).save(any(User.class));
    }

    // ❌ FAILED CASE
    @Test
    void createUser_duplicateUsername() {
        when(userRepository.existsByUsername("john")).thenReturn(true);

        assertThrows(RuntimeException.class,
                () -> userService.createUser("john", "password123"));

        verify(userRepository, never()).save(any());
    }
}