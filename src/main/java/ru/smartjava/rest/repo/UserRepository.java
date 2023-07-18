package ru.smartjava.rest.repo;

import ru.smartjava.rest.enums.Authorities;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);

}
