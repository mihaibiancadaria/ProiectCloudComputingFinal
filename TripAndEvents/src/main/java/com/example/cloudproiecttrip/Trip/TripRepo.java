package com.example.cloudproiecttrip.Trip;

import com.example.cloudproiecttrip.utils.AllRowMappers;
import com.example.cloudproiecttrip.utils.Repo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class TripRepo implements Repo<Trip> {
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private RowMapper<Trip> mapperCreated;
//    RowMapper<User> mapperUserCreated = AllRowMappers.userMapper();

    public TripRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Trip save(Trip object, Long id) {
        sql = "INSERT INTO trip VALUES (?,?,?,?,?,?)";
        Date dateStart = new Date(object.getStartDate().getTime());
        Date dateEnd = new Date(object.getEndDate().getTime());
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, object.getTripName());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setString(4, object.getCountryName().toString());
            preparedStatement.setObject(5, dateStart);
            preparedStatement.setObject(6, dateEnd);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        Long tripId = generatedKeyHolder.getKey().longValue();
        object.setIdTrip(tripId);

//        sql = "INSERT INTO trip_user VALUES(?,?,?)";
//        jdbcTemplate.update(sql, null, id, tripId);
        return object;
    }

//    public User addUserToTrip(Long idTrip, Long idUser){
//        sql = "SELECT * FROM userapp WHERE idU = ?";
//        List<User> users = jdbcTemplate.query(sql, mapperUserCreated, idUser);
//        if(users.isEmpty()){
//            return null;
//        }
//        else{
//            sql = "INSERT INTO trip_user VALUES(?,?,?)";
//            jdbcTemplate.update(sql, null, idUser, idTrip);
//            return users.get(0);
//        }
//    }

    @Override
    public List<Trip> getAll() {
        sql = "SELECT * FROM trip";
        mapperCreated = AllRowMappers.tripMapper();

        return jdbcTemplate.query(sql, mapperCreated);
    }

    @Override
    public Optional<Trip> getObject(Long id) {
        String sql = "SELECT * FROM trip WHERE idT= ?";

        mapperCreated = AllRowMappers.tripMapper();

        List<Trip> tripList = jdbcTemplate.query(sql, mapperCreated, id);
        if (tripList.isEmpty())
            return Optional.empty();
        else
            return Optional.of(tripList.get(0));
    }

    @Override
    public boolean delete(Long id) {
//        sql = "DELETE FROM trip_user WHERE idTrip=?";
//        jdbcTemplate.update(sql, id);
        sql = "DELETE FROM event WHERE idTrip=?";
        jdbcTemplate.update(sql, id);
//        sql = "DELETE FROM expenses WHERE idTrip=?";
//        jdbcTemplate.update(sql, id);
//        sql = "DELETE FROM task WHERE idTrip=?";
//        jdbcTemplate.update(sql, id);
//        sql = "DELETE FROM comment WHERE idTrip=?";
//        jdbcTemplate.update(sql, id);

        sql = "DELETE FROM trip WHERE idT=?";
        if(jdbcTemplate.update(sql, id)==0)
            return false;
        else
            return true;
    }

//    public List<User> getParticipants(Long idTrip){
//        sql = "SELECT idU, name, surname, email, u.description, password, age FROM userapp u INNER JOIN trip_user ut ON u.idU = ut.idUser INNER JOIN trip t ON t.idT = ut.idTrip WHERE t.idT = ?";
//        return jdbcTemplate.query(sql, mapperUserCreated, idTrip);
//    }
}
