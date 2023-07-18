package ru.smartjava.rest.repo;

import org.springframework.stereotype.Repository;
import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.user.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepositoryImpl {

    List<Person> personList = new ArrayList<>() {
        {
            new Person("Ivan","test", List.of(Authorities.READ));
            new Person("Olga","123456", List.of(Authorities.READ, Authorities.WRITE));
            new Person("Nikita","123", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        }
    };

    public List<Authorities> getUserAuthorities(String user, String password) {
        Optional<Person> person = personList.stream().filter(it-> Objects.equals(it.getName(), user)).findFirst();
        return person.map(Person::getAuthorities).orElse(null);

//        Person test = personList.stream().filter(it-> Objects.equals(it.getName(), user)).findFirst().orElseThrow(() -> new UnauthorizedUser("UnauthorizedUser"));
//        if(Objects.equals(test.getPassword(), password)) {
//            return test.getAuthorities();
//        }
//
//        throw new InvalidCredentials("InvalidCredentials");
    }
}
