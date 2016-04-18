package ru.itis.inform.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Document getDocumentById(@PathVariable int id){
        return documentService.getDocumentsInformation(id);
    }

    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.GET)
    public List<Participants> getAdditionalToDocument(@PathVariable int documentId){
        return participantService.getListOfPArticipants(documentId);
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "HELLO!";
    }

}
