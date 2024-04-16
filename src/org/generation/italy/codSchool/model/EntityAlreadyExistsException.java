package org.generation.italy.codSchool.model;

public class EntityAlreadyExistsException extends Exception {
    private int id;
    private String className;
    public EntityAlreadyExistsException(int id, String className) {
        super(String.format("esiste già un %s con id %d",className,id));
        //message="ciao"; non posso farlo perche è var della madre
        this.id = id;
        this.className = className;
    }
    public int getId() {
        return id;
    }
    public String getClassName() {
        return className;
    }
    

}
