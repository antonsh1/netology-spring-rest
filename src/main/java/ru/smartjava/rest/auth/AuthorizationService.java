package ru.smartjava.rest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.exceptions.InvalidCredentials;
import ru.smartjava.rest.exceptions.UnauthorizedUser;
import ru.smartjava.rest.repo.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
