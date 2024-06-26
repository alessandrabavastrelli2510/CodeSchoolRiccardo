package org.generation.italy.codSchool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import org.generation.italy.codSchool.model.Configuration;
import org.generation.italy.codSchool.model.Course;
import org.generation.italy.codSchool.model.CourseRepository;
import org.generation.italy.codSchool.model.Exam;
import org.generation.italy.codSchool.model.FileStudentRepository;
import org.generation.italy.codSchool.model.Student;
import org.generation.italy.codSchool.model.MemoryStudentRepository;
import org.generation.italy.codSchool.model.UserInterface;
import org.generation.italy.codSchool.model.Area;

public class Start {

    static{
        MemoryStudentRepository studentRepo = new MemoryStudentRepository();
        CourseRepository courseRepo = new CourseRepository();
        Student st = studentRepo.findById(1);
        Course course = courseRepo.getCourse(1);
        Exam ex1 = new Exam("Java Advance", 10, course);
        Exam ex2 = new Exam("SQL", 6, course);

        st.addCourse(course);
        course.enroll(st);
        st.doExam(ex1);
        st.doExam(ex2);
    }
    public static void pasticcioArray(ArrayList a){
        a.add(Area.CODING);
    }
    public static void main(String[] args) {
       
        // simulazione scuola corsi da linea di comando con menù scelta:
        //corsi: programmazione, sistemistica e grafica 
        //hanno un id, titolo area e livello di difficolta (basic intermediate advance e guru)
            // 1)dammi lista corsi che sono gestiti dalla scuola
            // 2)crea nuovo corso e aggiungilo alla lista       *
            // 3)dammi lista studenti iscritti a un corso (input id corso)
            // 4)iscrivere nuovo studente a un corso (input studente e id corso)
            // ogni studente ha una lista di esami per ogni corso che segue (ogni esami ha titolo e voto finale)
            // 5)inserire id studente id corso e avere indietro la media dei voti che quello studente ha avuto in quel corso

        
         ArrayList<String> as=new ArrayList<>();
         pasticcioArray(as);
         String maAncheNo=as.get(0);
        as.add("Pippo");
        as.add(3);
        as.add(new Studente());
        String s= as.get(0);
        ArrayList a=new ArrayList();
        a.add("Pippo");
        a.add(3);
        a.add(new Student());
        String forse=(String) a.get(0);






        // UserInterface u = new UserInterface();
        
        // u.doMenu();
        // Student student1=new Student("Giulio","Zalone");
        // Student student2=new Student("Giulio","Zalone");

        // student1.setId(20);
        // student2.setId(20);
        // Set<Student> hs=new HashSet<>();
        // System.out.println(student1.hashCode());
        // System.out.println(student2.hashCode());
        // hs.add(student1); //qui viene eseguito hashCode()
        // hs.add(student2);//qui viene eseguito hashCode() e equals()
        // Student student3=student2; //sta copiando l'indirizzo, ho due indirizzi che puntano a stesso oggetto
        // //System.out.println(student1.equals(student2));
        // // System.out.println(student1==student2);
        // // System.out.println(student2==student3);
        // //hs.add(student3); //size rimane due 
        // //System.out.println(student2.equals(student3));
        // System.out.println(hs.size());
        FileStudentRepository studentRepo=new FileStudentRepository(Configuration.fileName);//possiamo fare lo stesso con memory
        UserInterface u=new UserInterface(studentRepo);
        try {
            u.doMenu();
        } catch (ClassNotFoundException e) {
            System.out.println("Errore nella configurazione del sistema, contattare l'amministrazione");
        }
    }
}
