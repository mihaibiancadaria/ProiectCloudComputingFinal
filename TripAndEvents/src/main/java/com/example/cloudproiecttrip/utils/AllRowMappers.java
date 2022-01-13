package com.example.cloudproiecttrip.utils;

import com.example.cloudproiecttrip.Event.Event;
import com.example.cloudproiecttrip.Event.EventType;
import com.example.cloudproiecttrip.Trip.Country;
import com.example.cloudproiecttrip.Trip.Trip;
import org.springframework.jdbc.core.RowMapper;

public class AllRowMappers {
    public static RowMapper<Trip> tripMapper() {
        RowMapper<Trip> rowMapper = (resultSet, rowNo) -> new Trip(
                resultSet.getLong("idT"),
                resultSet.getString("tripName"),
                resultSet.getString("description"),
                Country.valueOf(resultSet.getString("location")),
                resultSet.getDate("startDate"),
                resultSet.getDate("endDate"));
        return rowMapper;
    }

    public static RowMapper<Event> eventMapper() {
        RowMapper<Event> rowMapper = (resultSet, rowNo) -> new Event(
                resultSet.getLong("idEvent"),
                resultSet.getString("nameEvent"),
                EventType.valueOf(resultSet.getString("eventType")),
                resultSet.getString("description"),
                resultSet.getDate("startTime"),
                resultSet.getDate("endTime"),
                resultSet.getBoolean("ticketsBought"));
        return rowMapper;
    }


}
