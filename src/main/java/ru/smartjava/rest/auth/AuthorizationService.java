package ru.smartjava.rest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.exceptions.UnauthorizedUser;
import ru.smartjava.rest.interfaces.UserRepository;
import ru.smartjava.rest.user.Person;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    @Autowired
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(Person person) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(person);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + person.getName());
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
