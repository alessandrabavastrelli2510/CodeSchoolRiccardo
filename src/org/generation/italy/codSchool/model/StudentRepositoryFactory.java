package org.generation.italy.codSchool.model;

public class StudentRepositoryFactory {
    public static AbstractStudentRepository createStudentRepository(String type){
        if("memo".equals(type)){
            return new MemoryStudentRepository();
        } else {
            return new FileStudentRepository(Configuration.fileName);
        }
    }

}
