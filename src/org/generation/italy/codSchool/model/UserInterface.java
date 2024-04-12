package org.generation.italy.codSchool.model;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner console = new Scanner(System.in);
    private StudentRepository studentRepo = new StudentRepository();
    private CourseRepository courseRepo = new CourseRepository();

    public int doMenu(){
        Scanner console = new Scanner(System.in);
        int choice;
        do{
            printMenu();
            choice = console.nextInt();
            console.nextLine();
            switch (choice) {
                case 0->System.out.println("Grazie per aver utilizzato il nostro programma, Arrivederci");
                case 1->printCourseList();
                case 2->createNewCourse();
                case 3->createStudentListForCourse();
                case 4->addStudentToCourse();
                case 5->printAverageForCourse();
                default->System.out.println("Comando non valido");
            }
            

        }while(choice != 0);
        console.close();
        return choice;
    }
    private void createNewCourse(){
        Course c = createCourse();
        courseRepo.save(c);
        System.out.println("Corso inserito con Id: " + c.getId());
    }

    private void printMenu(){
        System.out.println("""
            MENU:
            0)Esci
            1)Lista corsi 
            2)Crea nuovo corso
            3)Lista studenti iscritti per corso
            4)Iscrivere nuovo studente a un corso 
            5)Media voti Studente per corso
            Inserisci scelta:
                """);
    }

    public void printCourseList(){
        System.out.println("Lista dei corsi:");
        ArrayList<Course> courses = courseRepo.getAllCourses();
        for (Course course : courses) {
            System.out.println(course);
            System.out.println("------------------------");
        } 
    }
    private void createStudentListForCourse(){
        System.out.print("Inserisci Id del corso:");
        int id = console.nextInt();
        console.nextLine();
        Course courseFound = courseRepo.getCourse(id);
        if(courseFound != null){
            for(Student s : courseFound.listStudents()){
                System.out.println(s);
            }
        } else {
            System.out.println("Questo corso non esiste");
        }
    }
    private void addStudentToCourse(){
        System.out.print("Inserisci Id del corso:");
        int idCourse = console.nextInt();
        console.nextLine();
        Course found = courseRepo.getCourse(idCourse);
        System.out.println("Inserisci l'id dello studente:");
        int idStudent = console.nextInt();
        console.nextLine();
        Student st1 = studentRepo.findById(idStudent);
        if(found != null && st1 != null){
            found.enroll(st1);
            st1.addCourse(found);
            System.out.println("Studente iscritto al corso");
        }else{
            System.out.println("Questo corso o lo studente non esistono");
        }
    }
    private void printAverageForCourse(){
        System.out.print("Inserisci Id dello studente:");
        int idS = console.nextInt();
        console.nextLine();
        Student st2 = studentRepo.findById(idS);
        System.out.print("Inserisci Id del corso:");
        int idC = console.nextInt();
        console.nextLine();
        Course c2 = courseRepo.getCourse(idC);
            if(st2 != null && c2 != null){
                System.out.printf("La media dei voti per lo studente %s per il corso con id %d è %.2f %n", st2.toString(), idC, st2.calculateAverageForCourse(idC));
            }
    }

    public Course createCourse(){
        return new Course(insertTitle(), insertAreaTitle(), insertDifficultyLevel());
    }

    private String insertTitle() {
        System.out.println("Inserisci titolo del corso:");
        return console.nextLine();
    }

    private Area insertAreaTitle() {
        Area area;
        
        do{
            printAreaName();
            System.out.println("Inserisci numero della facoltà:");
            int numArea = console.nextInt();
            console.nextLine();

            area = Area.findAreaByCode2(numArea);
            
            if(area != null){
                System.out.println("Hai scelto la facoltà: " + area.toString() + "\n");
            }else{
                System.out.println("Hai inserito un codice errato");
            }
        }while(area == null);
        return area;
    }

    private void printAreaName(){
        for (String line : Area.getAreaNames()) {
            System.out.println(line);
        }
    }

    private  DifficultyLevel insertDifficultyLevel() {
        boolean isFound = false;
        DifficultyLevel level = null;
        int numLevel;
        do{
            printAllDifficultLevel();
            System.out.println("Inserisci numero della difficoltà:");
            numLevel = console.nextInt();
            console.nextLine();

            for(int i=0; i<DifficultyLevel.values().length; i++){
                if(numLevel == (i+1)){
                    isFound = true;
                    level = DifficultyLevel.values()[i];
                }
            }
            System.out.println("Hai scelto la difficoltà: " + level.toString() + "\n");    //controllo inserimento
        }while(!isFound);
        return level;
    }
    public static void printAllDifficultLevel(){
        System.out.println("Lista difficoltà corsi:");
        for(int i=0; i<DifficultyLevel.values().length; i++){
            System.out.println((i+1) + ") " + DifficultyLevel.values()[i]);
        }
        System.out.println();
    }
     // private String insertName() {
    //     System.out.println("Inserisci nome studente:");
    //     String n = console.nextLine();
    //     return n;
    // }

    // private String insertLastname() {
    //     System.out.println("Inserisci cognome studente:");
    //     String l = console.nextLine();
    //     return l;
    // }

    // public Student createStudent(){
    //     Student s = new Student(insertName(), insertLastname());
    //     return s;
    // }

}
