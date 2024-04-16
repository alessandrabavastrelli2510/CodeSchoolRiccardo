package org.generation.italy.codSchool.model;

public interface AbstractStudentRepository {
     Student findById(int id)throws Exception;
}
