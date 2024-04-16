package org.generation.italy.codSchool.model;

import java.util.HashMap;

public class MemoryStudentRepository implements AbstractStudentRepository{
     private static HashMap <Integer, Student> students = new HashMap<>();

    static{
        Student s1 = new Student("Giulio", "Zalone");
        Student s2 = new Student("Peppina", "DiCapri");
        students.put(s1.getId(), s1);
        students.put(s2.getId(), s2);
    }

     public Student findById(int id){
        return students.get(id);
     }
     
}
