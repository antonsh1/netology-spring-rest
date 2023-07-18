package ru.smartjava.rest.interfaces;

import ru.smartjava.rest.enums.Authorities;
import ru.smartjava.rest.user.Person;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(Person person);

}
