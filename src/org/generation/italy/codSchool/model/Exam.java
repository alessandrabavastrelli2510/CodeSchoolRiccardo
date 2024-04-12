package org.generation.italy.codSchool.model;

public class Exam {
    private String title;
    private double vote;
    private Course course;

    public Exam(String title, double vote, Course course){
        this.title = title;
        this.vote = vote;
        this.course = course;
    }

    public int getCourseId(){
        return course.getId();
    }

    public Course getCourse(){
        return course;
    }

    public double getVote() {
        return vote;
    }

    public String getTitle() {
        return title;
    }
}
