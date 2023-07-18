package ru.smartjava.rest.interfaces;

import ru.smartjava.rest.enums.Authorities;

import java.util.List;

public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);

}
