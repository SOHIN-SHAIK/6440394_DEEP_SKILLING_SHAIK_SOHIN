package SpringMockitoTesting.MockTest.repository;

import SpringMockitoTesting.MockTest.entity.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
}
