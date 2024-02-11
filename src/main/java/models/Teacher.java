package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Teacher {
    private int id;
    private String surname;
    private String name;
    private int age;
    private String email;

    public Teacher(String name, String surname, int age, String email)
    {
        setName(name);
        setSurname(surname);
        setAge(age);
        setEmail(email);
    }


    @Override
    public String toString() {
        return id + " " +  name + " " + surname + " " + age + " " + email;
    }
}