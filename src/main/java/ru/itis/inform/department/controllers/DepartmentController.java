package ru.itis.inform.department.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
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


    @RequestMapping(value = "/document/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForGetDocumentById(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }


    // working
    @RequestMapping(value = "/document/{id}", method = RequestMethod.GET)
    public String getDocumentById(@PathVariable(value = "id") int id, @RequestHeader(value = "Auth-Token") String token){
        //tokensService.vefifyToken(token);
        //MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        DocumentDto dto = new DocumentDto(documentService.getDocumentsInformation(id));
        return documentService.getDocumentsInformation(id).toString();
    }

    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForAdditionalToDocument(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }


    // working
    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.GET)
    public List<ParticipantDto> getAdditionalToDocument(@PathVariable(value = "documentId") int documentId,@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        ParticipantsDto dto = new ParticipantsDto();
        dto.setListParticipants(participantService.getListOfPArticipants(documentId));

        return dto.getParticipants();
    }

    //working
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "HELLO!";
    }


    @RequestMapping(value = "/signin", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForAddNewUser(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String addNewUser(@RequestBody UserDto dto, @RequestBody PasswordDto passwordDto){
        usersService.addUser(converter.getUserDao(dto));
        passwordService.addKey(converter.getPasswordDao(passwordDto));
        tokensService.setToken(converter.getUserDao(dto), converter.getPasswordDao(passwordDto));
        return tokensService.getToken(converter.getUserDao(dto));
    }

    @RequestMapping(value = "/login", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForLogin(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    //working
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void login(@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
    }

    @RequestMapping(value = "/documents", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForAddNewDocument(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/documents", method = RequestMethod.POST)
    public void addNewDocument(@RequestBody DocumentDto dto, @RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        documentService.addDocument(converter.getDocumentDao(dto));

    }
    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForAddNewAdditional(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }
    @RequestMapping(value = "/document/{documentId}/additional", method = RequestMethod.POST)
    public void addNewAdditional(@PathVariable(value = "documentId") int documentId,@RequestBody ParticipantDto dto, @RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        participantService.addParticipants(converter.getParticipantDao(dto));
    }
    @RequestMapping(value = "/documents", method = RequestMethod.OPTIONS)
    public ResponseEntity onOptionsForGetListing(@RequestHeader(value = "ORIGIN") String origin) {
        MultiValueMap<String, String> headers = prepareHeadersWithAllow(origin);
        return new ResponseEntity(headers, HttpStatus.OK);
    }
    // working
    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public DocumentsDto getListing(@RequestHeader(value = "Auth-Token") String token){
        tokensService.vefifyToken(token);
        return  converter.getDocumentsDto(documentService.getListOfUserDocuments(tokensService.getUser(token).getUserId()));

    }
    private MultiValueMap<String, String> prepareHeadersWithAllow(String origin) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", origin);
        return headers;
    }
}
