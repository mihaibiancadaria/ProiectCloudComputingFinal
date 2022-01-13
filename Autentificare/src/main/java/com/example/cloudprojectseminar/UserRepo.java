package com.example.cloudprojectseminar;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo implements Repo<User>{
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private RowMapper<User> mapperCreated;

    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User save(User object) {
        sql = "INSERT INTO userapp VALUES (?,?,?,?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setObject(2, object.getName());
            preparedStatement.setObject(3, object.getSurname());
            preparedStatement.setObject(4, object.getEmail());
            preparedStatement.setObject(5, object.getDescription());
            preparedStatement.setObject(6, object.getPassword());
            preparedStatement.setObject(7, object.getAge());
            return preparedStatement;
        };

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        object.setId(generatedKeyHolder.getKey().longValue());
        return object;
    }

    @Override
    public Optional<User> getObject(Long id) {
        String sql = "SELECT * FROM userapp WHERE idU= ?";

        mapperCreated = AllRowMappers.userMapper();

        List<User> userList = jdbcTemplate.query(sql, mapperCreated, id);
        if (userList.isEmpty())
            return Optional.empty();
        else
            return Optional.of(userList.get(0));
    }

    public List<User> getObject_name(String name){
        String sql = "SELECT * FROM userapp WHERE name= ?";
        mapperCreated = AllRowMappers.userMapper();

        List<User> userList = jdbcTemplate.query(sql, mapperCreated, name);
        if (userList.isEmpty())
            return null;
        else
            return userList;
    }

    @Override
    public List<User> getAll() {
        sql = "SELECT * FROM userapp";
        mapperCreated = AllRowMappers.userMapper();

        return jdbcTemplate.query(sql, mapperCreated);
    }

    @Override
    public boolean delete(Long id){
        sql = "DELETE FROM userapp WHERE idU=?";
        if(jdbcTemplate.update(sql, id)==0)
            return false;
        else
            return true;
    }
}
