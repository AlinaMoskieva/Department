package ru.itis.inform.department.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.document.DocumentDao;
import ru.itis.inform.department.dao.models.Document;

import java.util.List;

/**
 * Created by Moskieva on 12.04.16.
 */
@Component
public class DocumentServiceImpl implements  DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document getDocumentsInformation(int documentId) {
        return documentDao.getDocument(documentId);
    }

    @Override
    public List<Document> getListOfUserDocuments(int userId) {
        return documentDao.getListOfDocuments(userId);
    }

    @Override
    public void addDocument(Document document) {
        documentDao.addDocument(document);
    }

    public static void main(String[] args) {
        DocumentServiceImpl impl = new DocumentServiceImpl();
        System.out.println(impl.getDocumentsInformation(1).toString());
    }
}
