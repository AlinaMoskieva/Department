package ru.itis.inform.department.dao.document;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.DaoArgumentsVerifier;
import ru.itis.inform.department.dao.document.DocumentDao;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.ParamsMapperImpl;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutorImpl;
import ru.itis.inform.department.dao.models.Document;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Moskieva on 01.04.16.
 */
@Component
public class DocumentDaoImpl implements DocumentDao {
    @Autowired
    DaoArgumentsVerifier daoArgumentsVerifier;
    @Autowired
    private  ParamsMapper paramsMapper;
    @Autowired
    private SqlQueryExecutor sqlQueryExecutor;

    // language=SQL
    public static final String SQL_GET_DOCUMENT_BY_ID = "SELECT * FROM document WHERE (id = :documentId)";
    // language=SQL
    public static final String SQL_GET_LIST_OF_DOCUMENTS = "SELECT * FROM document WHERE (userid = :userId)";






    private final RowMapper<Document> DOCUMENT_ROW_MAPPER = new RowMapper<Document>() {
        @Override
        public Document mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Document(resultSet.getInt("id"), resultSet.getInt("userId"),
                        resultSet.getString("denominationOfApplicant"), resultSet.getString("legalStatusOfTheApplicant"),
                        resultSet.getString("theTypeLaborArbitrators"), resultSet.getString("formOfThePreparationOfLaborArbitrators"),
                        resultSet.getString("timeOfThePreparationOfLaborArbitrators"), resultSet.getString("preferredLocation"),
                        resultSet.getString("mailingAddressOfTheApplicant"), resultSet.getString("contactPhoneNumbers"),
                        resultSet.getString("emailAddress"), resultSet.getString("positionApplicant"), resultSet.getString("fullName"), resultSet.getString("date"));
            }catch (SQLException e){
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public List<Document> getListOfDocuments(int userId) {
        daoArgumentsVerifier.verifyUser(userId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("userId"), asList(userId));
        return sqlQueryExecutor.queryForObjects(SQL_GET_LIST_OF_DOCUMENTS, paramMap, DOCUMENT_ROW_MAPPER);

    }

    @Override
    public Document getDocument(int documentId) {
        daoArgumentsVerifier.verifyDocument(documentId);
        Map<String, Object> paramMap = paramsMapper.asMap(asList("documentId"), asList(documentId));
        return sqlQueryExecutor.queryForObject(SQL_GET_DOCUMENT_BY_ID, paramMap, DOCUMENT_ROW_MAPPER);

    }

    public static void main(String[] args) {
        DocumentDaoImpl d = new DocumentDaoImpl();
        System.out.println(d.getDocument(1).toString());
    }
}
