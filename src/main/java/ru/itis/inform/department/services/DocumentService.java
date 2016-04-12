package ru.itis.inform.department.services;

import ru.itis.inform.department.dao.models.Document;

import java.util.List;

/**
 * Created by Moskieva on 12.04.16.
 */
public interface DocumentService {
    /**
     * получение документа пользователя
     * @param documentId id документа
     * @return документ
     */
    Document getDocumentsInformation(int documentId);

    /**
     * получение всех документов пользователя
     * @param userId id пользователя
     * @return лист документов
     */
    List<Document> getListOfUserDocuments (int userId);
}
