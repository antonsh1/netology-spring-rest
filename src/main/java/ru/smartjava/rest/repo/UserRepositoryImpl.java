package ru.smartjava.rest.repo;

import org.springframework.stereotype.Repository;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.interfaces.UserRepository;
import ru.smartjava.rest.user.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<Person> personList = new ArrayList<>() {
        {
            add(new Person("Ivan","test", List.of(Authorities.READ)));
            add(new Person("Olga","123456", List.of(Authorities.READ, Authorities.WRITE)));
            add(new Person("Nikita","123", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        }
    };

    public List<Authorities> getUserAuthorities(String user, String password) {
        Optional<Person> person = personList.stream().filter(it-> Objects.equals(it.getName(), user) && Objects.equals(it.getPassword(), password)).findFirst();
        return person.map(Person::getAuthorities).orElse(null);
    }
}
