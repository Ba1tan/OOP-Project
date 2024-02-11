package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Student {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String email;

    public Student(String name, String surname, int age, String email)
    {
        setName(name);
        setSurname(surname);
        setAge(age);
        setEmail(email);
    }

    // some cmt

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + age + " " + email;
    }
}