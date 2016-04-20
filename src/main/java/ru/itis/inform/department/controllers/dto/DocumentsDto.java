package ru.itis.inform.department.controllers.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moskieva on 19.04.16.
 */
public class DocumentsDto {
    private List<DocumentDto> documents = new ArrayList<>();

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(DocumentDto document) {
        this.documents.add(document);
    }
}
