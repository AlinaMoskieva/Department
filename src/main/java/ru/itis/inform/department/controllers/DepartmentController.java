package ru.itis.inform.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.department.controllers.dto.*;
import ru.itis.inform.department.controllers.dto.converters.DtoAndEntityConverter;
import ru.itis.inform.department.services.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private TokensService tokensService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private DtoAndEntityConverter converter;

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

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String addNewUser(@RequestBody UserDto dto, @RequestBody PasswordDto passwordDto){
        usersService.addUser(converter.getUserDao(dto));
        passwordService.addKey(converter.getPasswordDao(passwordDto));
        tokensService.setToken(converter.getUserDao(dto), converter.getPasswordDao(passwordDto));
        return tokensService.getToken(converter.getUserDao(dto));
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(){

    }

}
