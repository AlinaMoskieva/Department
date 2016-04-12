package ru.itis.inform.department.dao.Exeptions;

/**
 * Created by Moskieva on 12.04.16.
 */
public class ParticipantNotFoundExeption extends RuntimeException {
    private String message = "";

    public ParticipantNotFoundExeption(int participantId){
        this.message = "Participant with "+ participantId +" not found.";
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
