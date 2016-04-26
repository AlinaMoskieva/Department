package ru.itis.inform.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.department.controllers.dto.*;
import ru.itis.inform.department.controllers.dto.converters.DtoAndEntityConverter;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;
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
    public DocumentDto getDocumentById(@PathVariable int id, @RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        DocumentDto dto = new DocumentDto(documentService.getDocumentsInformation(id));
        return dto;
    }

    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.GET)
    public List<ParticipantDto> getAdditionalToDocument(@PathVariable int documentId,@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
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
    public void login(@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
    }
    @RequestMapping(value = "/documents", method = RequestMethod.POST)
    public void addNewDocument(@RequestBody DocumentDto dto, @RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        documentService.addDocument(converter.getDocumentDao(dto));

    }
    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.POST)
    public void addNewAdditional(@RequestBody ParticipantDto dto, @RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        participantService.addParticipants(converter.getParticipantDao(dto));
    }
    // add DocumentsDto
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public void getListing(@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
      //  return converter.getDocumentsDto(documentService.getListOfUserDocuments(tokenDto.getUserId()));

    }
}
