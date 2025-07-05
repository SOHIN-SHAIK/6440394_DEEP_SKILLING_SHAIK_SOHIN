package SpringMockitoTesting.MockTest.service;

import SpringMockitoTesting.MockTest.entity.User;
import SpringMockitoTesting.MockTest.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
