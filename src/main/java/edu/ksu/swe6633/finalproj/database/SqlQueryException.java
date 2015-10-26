package edu.ksu.swe6633.finalproj.database;

import java.sql.SQLException;

public class SqlQueryException extends RuntimeException {
    public SqlQueryException(SQLException e) {
        super(e);
    }
}
