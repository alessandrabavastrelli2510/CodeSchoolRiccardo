package org.generation.italy.codSchool.model;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class FileStudentRepository implements AbstractStudentRepository{
    private String fileName;

            
    public FileStudentRepository(String fileName) {
        this.fileName = fileName;
    }

    // @Override
    // public Student findById(int id) {
    //     BufferedReader br=null;
    //     try{
    //         FileReader fr=new FileReader("nonesisto.txt"); //prende classe, legge file un carattere alla volta-->FILE NOT FOUND
    //         br=new BufferedReader(fr); //legge tutti i cararatteri riga per riga fino ad andare a capo
    //         String line=br.readLine();//metodo per farlo -->IO EXCEPTION
    //         System.out.println(line.length());//-->DAREBBE NULL POINTER
    //         Class x=Class.forName("org.generation.italy.codSchool.model.Area");//-->CLASS NOT FOUND
    //     } catch(FileNotFoundException e){
    //         System.out.println(e.getMessage());
    //     } catch (IOException e) {
    //         System.out.println(e.getMessage());
    //     } catch (ClassNotFoundException e) {
    //         System.out.println(e.getMessage());
    //     } finally {
    //         System.out.println("io eseguo sempre");
    //         try {
    //             if(br !=null){
    //             br.close();
    //             }
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }

    //     }
    //     System.out.println("anche io penso di eseguire sempre e invece mi sbaglio");





    // }
    @Override
    public Student findById(int id) throws FileNotFoundException, IOException, ClassNotFoundException {
       try(BufferedReader br=new BufferedReader(new FileReader(Configuration.fileName));){
        //String line = br.readLine();
        //sout(line.length());
            Class x=Class.forName("org.generation.italy.codSchool.model.Aree");//-->CLASS NOT FOUND
            return null;
       }

        // } catch(FileNotFoundException e){
        //     System.out.println(e.getMessage());
        // } catch (IOException e) {
        //     System.out.println(e.getMessage());
        // } catch (ClassNotFoundException e) {
        //     System.out.println(e.getMessage());
        // }
       // System.out.println("anche io penso di eseguire sempre e invece mi sbaglio");

        
    }
}
