package ru.itis.inform.department.dao;

import ru.itis.inform.department.dao.models.Document;

import java.util.List;

/**
 * Created by Moskieva on 29.03.16.
 */
public interface DocumentDao {
    /**
     * создание документа
     */
    void newDocument();

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

    /**
     * Удаление документа
     * @param documentId id документа
     */
    void removeDocument (int documentId);

}
