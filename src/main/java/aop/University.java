package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Petr Petrov", 4, 4.85);
        Student st2 = new Student("Michael Ivanov", 2, 8.3);
        Student st3 = new Student("Elena Sidorova", 1, 9.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    public List<Student> getStudents(){
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;
    }

}
