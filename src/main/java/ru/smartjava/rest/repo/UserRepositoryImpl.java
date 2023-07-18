package ru.smartjava.rest.repo;

import org.springframework.stereotype.Repository;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.user.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<Person, List<Authorities>> repository = new HashMap<>() {
        {
            put(new Person("Ivan", "testtest"), List.of(Authorities.READ));
            put(new Person("Olga", "12345678"), List.of(Authorities.READ, Authorities.WRITE));
            put(new Person("Nikita", "test1234"), List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        }
    };

    public List<Authorities> getUserAuthorities(String user, String password) {
        Person person = new Person(user, password);
        return repository.get(person);
    }
}
