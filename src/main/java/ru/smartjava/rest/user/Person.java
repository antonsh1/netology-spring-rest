package ru.smartjava.rest.user;

import java.util.Objects;

public class Person {

    private String name;

    private String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
