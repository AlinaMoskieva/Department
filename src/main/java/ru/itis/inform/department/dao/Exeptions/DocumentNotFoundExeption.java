package ru.itis.inform.department.dao.exeptions;

/**
 * Created by Moskieva on 12.04.16.
 */
public class DocumentNotFoundExeption extends RuntimeException {
    private String message="";

    public DocumentNotFoundExeption(int documentId){
        this.message = "Document with " + documentId + " id is not found";
    }
    @Override
    public String toString(){
        return message;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
