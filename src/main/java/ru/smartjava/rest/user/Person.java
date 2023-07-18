package ru.smartjava.rest.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Person {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 8, max = 256)
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
