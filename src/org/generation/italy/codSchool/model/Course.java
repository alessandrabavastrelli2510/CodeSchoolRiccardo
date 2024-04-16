package org.generation.italy.codSchool.model;

import java.util.ArrayList;

public class Course implements Comparable<Course>{
    private int id;
    private String title;
    private Area area;
    private DifficultyLevel difficultyLevel;
    private ArrayList<Student> students; 
    private static int idGenerator = 1;

    public Course(String title, Area area, DifficultyLevel difficultyLevel){
        this.id = Course.idGenerator++;
        this.title = title;
        this.area = area;
        this.difficultyLevel = difficultyLevel;
        this.students = new ArrayList<>();
        //courses.put(id, this);
    }

    public ArrayList<Student> listStudents(){
        return students;
    }

    public int enroll(Student s){
        students.add(s);
        return students.size();
    }

    public String toString(){
        return String.format("Id: %d, Titolo: %s, Area: %s, Livello Difficoltà: %s", id, title, area.toString(), difficultyLevel.toString());
    }


    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Course o) {
       return this.title.compareTo(o.title);
    }

  


}
