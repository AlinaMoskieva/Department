package ru.itis.inform.department.controllers.dto;


import ru.itis.inform.department.dao.models.Participants;

import java.util.List;

/**
 * Created by Moskieva on 19.04.16.
 */
public class ParticipantsDto {
    private List<ParticipantDto> participants;

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDto> participants) {
        this.participants = participants;
    }
    public void setListParticipants (List<Participants> participants){
        if (!participants.isEmpty()){
            for (int i = 0; i<participants.size(); i++){
                ParticipantDto dto = new ParticipantDto(participants.get(i));
                this.participants.add(dto);

            }
        }
    }
}

