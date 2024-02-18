package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Courses {
    private int id;
    private String courseName;
    private int teacher_id;
    private String teacher_name;
    private String teacher_surname;
    private int teacher_age;
    private String teacher_email;

    public Courses(String courseName, int teacher_id)
    {
        setCourseName(courseName);
        setTeacher_id(teacher_id);
    }
    @Override
    public String toString() {
        return id + " " + courseName + " " + teacher_name + " " + teacher_surname + " " + teacher_age + " " + teacher_email + " "  + teacher_id;
    }
}