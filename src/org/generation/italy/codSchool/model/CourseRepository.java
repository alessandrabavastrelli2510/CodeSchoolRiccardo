package org.generation.italy.codSchool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class CourseRepository {
    private static final String List = null;
    private static HashMap <Integer, Course> courses = new HashMap<>();

//se abbiamo una variabile statica che dobbiamo inizializzare si usa il blocco static (funge come il costruttore con le variabile non static)
    static{
        Course corso1 = new Course("Corso di Java", Area.CODING, DifficultyLevel.INTERMEDIATE);
        Course corso2 = new Course("Corso di Matematica", Area.DESIGN, DifficultyLevel.ADVANCED);
        courses.put(corso1.getId(), corso1);
        courses.put(corso2.getId(), corso2);
    }

    public Course getCourse(int idCourse) {
        return courses.get(idCourse);
    }

    public List<Course> getAllCourses(){
        var cs=courses.values();
        List<Course> lcs=new ArrayList<>();
        Collections.sort(lcs,new CourseComparatorById()); //ordina per id
        Collections.sort(lcs); //ordina per string
        Collections.sort(lcs,new Comparator<Course>(){//attenzione è interfaccia, il new è di  anonymous inner class
            @Override
            public int compare(Course c1,Course c2){
                return c1.getId()-c2.getId();
            }
        });
        Collections.sort(lcs, (c1,c2) -> {
            int x=3;
            return c1.getId()-c2.getId();
        });
        //return new ArrayList<>(courses.values()); ho cambiato in list però
        return lcs;
    }

    public void save(Course c) throws EntityAlreadyExistsException {
        if(courses.containsKey(c.getId())){
            EntityAlreadyExistsException e=new EntityAlreadyExistsException(c.getId(),getClass().getSimpleName());
            throw e;
        }
        courses.put(c.getId() ,c);
    }



}
