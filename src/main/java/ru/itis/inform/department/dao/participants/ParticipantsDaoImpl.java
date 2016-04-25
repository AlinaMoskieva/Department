package ru.itis.inform.department.dao.participants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.itis.inform.department.dao.DaoArgumentsVerifier;
import ru.itis.inform.department.dao.jdbc.ParamsMapper;
import ru.itis.inform.department.dao.jdbc.SqlQueryExecutor;
import ru.itis.inform.department.dao.models.Document;
import ru.itis.inform.department.dao.models.Participants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Moskieva on 12.04.16.
 */
@Component
public class ParticipantsDaoImpl implements ParticipantsDao {
    @Autowired
    DaoArgumentsVerifier daoArgumentsVerifier;
    @Autowired
    ParamsMapper paramsMapper;
    @Autowired
    SqlQueryExecutor sqlQueryExecutor;

    // language=SQL
    public static final String SQL_GET_LIST_OF_PARTICIPANTS = "SELECT * FROM participant WHERE (documentid = :documentId) ";
    // language=SQL
    public static  final String SQL_INSERT_PARTICIPANT_INTO_PARTICIPANTS =
            "INSERT INTO participant VALUES (:id, :fullName, :education, :placeOfWork, :positionAtWork, :documentId)";

    static final RowMapper<Participants> PARTICIPANTS_ROW_MAPPER = new RowMapper<Participants>() {
        @Override
        public Participants mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                return new Participants(resultSet.getInt("id"),resultSet.getInt("documentId"),
                        resultSet.getString("fullName"), resultSet.getString("education"),
                        resultSet.getString("placeOfWork"), resultSet.getString("positionAtWork"));
            } catch (SQLException e) {
                throw new IllegalArgumentException(e);
            }
        }
    };

    @Override
    public void newParticipant(Participants participants) {
        daoArgumentsVerifier.verifyDocument(participants.getDocumentId());
        Map<String,Object> paramMap = paramsMapper.asMap(
                asList("id", "fullName", "education", "placeOfWork",
                        "positionAtWork", "documentId"),
                asList(participants.getId(), participants.getFullName(), participants.getEducation(),
                        participants.getPlaceOfWork(), participants.getPositionAtWork(), participants.getDocumentId()));
        sqlQueryExecutor.updateQuery(SQL_INSERT_PARTICIPANT_INTO_PARTICIPANTS, paramMap);

    }

    @Override
    public List<Participants> getListOfParticipant(int documentId) {
        daoArgumentsVerifier.verifyDocument(documentId);
        return sqlQueryExecutor.queryForObjects(SQL_GET_LIST_OF_PARTICIPANTS, PARTICIPANTS_ROW_MAPPER);
    }

}
