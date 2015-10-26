package edu.ksu.swe6633.finalproj.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetMapper<T> {

    T mapResultSet(ResultSet rs) throws SQLException;
}
