package com.example.cloudproiecttrip.Event;

import com.example.cloudproiecttrip.utils.AllRowMappers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class EventRepo {
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private RowMapper<Event> mapperCreated;

    public EventRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Event save(Event object, Long id) {
        sql = "INSERT INTO event VALUES(?,?,?,?,?,?,?,?)";
        Date timeStart = new Date(object.getStartTime().getTime());
        Date timeEnd = new Date(object.getEndTime().getTime());

        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, object.getNameEvent());
            preparedStatement.setString(3, object.getEventType().toString());
            preparedStatement.setString(4, object.getDescription());
            preparedStatement.setDate(5, timeStart);
            preparedStatement.setDate(6, timeEnd);
            preparedStatement.setBoolean(7, object.isTicketsBought());
            preparedStatement.setLong(8, id);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        Long eventId = generatedKeyHolder.getKey().longValue();
        object.setIdEvent(eventId);

        return object;
    }

    public List<Event> getAll(Long idTrip) {
        sql = "SELECT * FROM event WHERE idTrip = ?";
        mapperCreated = AllRowMappers.eventMapper();

        return jdbcTemplate.query(sql, mapperCreated, idTrip);
    }
}
