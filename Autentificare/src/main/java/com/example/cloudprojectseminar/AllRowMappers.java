package com.example.cloudprojectseminar;


import org.springframework.jdbc.core.RowMapper;

public class AllRowMappers {
    public static RowMapper<User> userMapper() {
        RowMapper<User> rowMapper = (resultSet, rowNo) -> new User(
                resultSet.getLong("idU"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("email"),
                resultSet.getString("description"),
                resultSet.getString("password"),
                resultSet.getInt("age"));
        return rowMapper;
    }

//    public static RowMapper<Trip> tripMapper() {
//        RowMapper<Trip> rowMapper = (resultSet, rowNo) -> new Trip(
//                resultSet.getLong("idT"),
//                resultSet.getString("tripName"),
//                resultSet.getString("description"),
//                Country.valueOf(resultSet.getString("location")),
//                resultSet.getDate("startDate"),
//                resultSet.getDate("endDate"));
//        return rowMapper;
//    }
//
//    public static RowMapper<Event> eventMapper() {
//        RowMapper<Event> rowMapper = (resultSet, rowNo) -> new Event(
//                resultSet.getLong("idEvent"),
//                resultSet.getString("nameEvent"),
//                EventType.valueOf(resultSet.getString("eventType")),
//                resultSet.getString("description"),
//                resultSet.getDate("startTime"),
//                resultSet.getDate("endTime"),
//                resultSet.getBoolean("ticketsBought"));
//        return rowMapper;
//    }
//
//    public static RowMapper<Comment> commentMapper() {
//        RowMapper<Comment> rowMapper = (resultSet, rowNo) -> new Comment(
//                resultSet.getLong("idCom"),
//                resultSet.getDate("datePosted"),
//                resultSet.getString("textComment"));
//        return rowMapper;
//    }
//
//    public static RowMapper<Expenses> expensesMapper() {
//        RowMapper<Expenses> rowMapper = (resultSet, rowNo) -> new Expenses(
//                resultSet.getLong("idExp"),
//                resultSet.getString("expenseDetails"),
//                resultSet.getDouble("sum"));
//        return rowMapper;
//    }
}
