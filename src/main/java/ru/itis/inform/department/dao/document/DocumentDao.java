package ru.itis.inform.department.dao.document;

import ru.itis.inform.department.dao.models.Document;

import java.util.List;

/**
 * Created by Moskieva on 29.03.16.
 */
public interface DocumentDao {

    /**
     * получение всех документов поьзователя
     * @param userId id пользователя
     * @return лист документов
     */
    List<Document> getListOfDocuments(int userId);

    /**
     * получение определенного документа
     * @param documentId id документа
     * @return документ
     */
    Document getDocument (int documentId);

    void addDocument(Document document);

}
