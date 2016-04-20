package ru.itis.inform.department.controllers.dto;


import java.util.List;

/**
 * Created by Moskieva on 19.04.16.
 */
public class ParticipantsDto {
    private List<ParticipantsDto> participants;

    public List<ParticipantsDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantsDto> participants) {
        this.participants = participants;
    }
}

