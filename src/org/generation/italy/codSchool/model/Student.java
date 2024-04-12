package org.generation.italy.codSchool.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private ArrayList <Exam> transcript;
    private ArrayList <Course> courses;
    private static int idGenerator = 1;

    public Student (String name, String lastname){
        this.id = Student.idGenerator++;
        this.name = name;
        this.lastname = lastname;
        this.transcript = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public double calculateAverageForCourse(int courseId){
        double sum = 0;
        int count = 0;
        for (Exam exam : transcript) {
            if(exam.getCourseId() == courseId){
                sum += exam.getVote();
                count++;
            }
        }
        return sum/count;
    }

    public double calculateAverage(){
        double sum = 0;
        for (Exam exam : transcript) {
            sum += exam.getVote();
        }
        return sum/transcript.size();
    }

    public String toString(){
        return String.format("Id: %d, Nome: %s, Cognome: %s", id, name, lastname);
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    @Override
    public boolean equals(Object o){
        System.out.println("chiamato equals");
        if(o==null){
            return false; //hashcode 
        }
        if(this.getClass()!=o.getClass()){ 
            return false; //generics
        }
        // if(o instanceof Student){
           // Student x=(Student)o;
        // } --> non posso farlo perche instanceOf può anche dare la figlia
        Student other=(Student)o;//castiamo o da object a  tipo Student 
        return this.id==other.id; //torniamo se è vero o no che siano uguali
    }
    
    @Override
    public int hashCode(){
        System.out.println("chiamato hashCode()");
        return id;

    }

    public void doExam(Exam e){
        transcript.add(e);
    }
}
