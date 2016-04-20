package ru.itis.inform.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.department.controllers.dto.DocumentDto;
import ru.itis.inform.department.controllers.dto.ParticipantDto;
import ru.itis.inform.department.controllers.dto.ParticipantsDto;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;
import ru.itis.inform.department.dao.models.User;
import ru.itis.inform.department.services.DocumentService;
import ru.itis.inform.department.services.ParticipantService;
import ru.itis.inform.department.services.UsersService;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public DocumentDto getDocumentById(@PathVariable int id){
        DocumentDto dto = new DocumentDto(documentService.getDocumentsInformation(id));
        return dto;
    }

    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.GET)
    public List<ParticipantDto> getAdditionalToDocument(@PathVariable int documentId){
        ParticipantsDto dto = new ParticipantsDto();
        dto.setListParticipants(participantService.getListOfPArticipants(documentId));

        return dto.getParticipants();
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "HELLO!";
    }

}//Token+user
