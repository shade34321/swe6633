package edu.ksu.swe6633.finalproj.database;



import com.mysql.jdbc.Statement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlQuery {

    private final String query;

    private PreparedStatement statement;

    public SqlQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public<T> List<T> queryForList(DataSource dataSource, final RowMapper<? extends T> rowMapper) {
        return query(dataSource, new ResultSetMapper<List<T>>() {
            @Override
            public List<T> mapResultSet(ResultSet rs) throws SQLException {
                List<T> results = new ArrayList<T>();
                while (rs.next()) {
                    results.add(rowMapper.mapRow(rs));
                }
                return results;
            }
        });
    }
    public<T> T queryForObject(DataSource dataSource, final RowMapper<T> rowMapper) {
        return query(dataSource, new ResultSetMapper<T>() {
            @Override
            public T mapResultSet(ResultSet rs) throws SQLException {
                if (!rs.next()) {
                    throw new RuntimeException("No results");
                }
                return rowMapper.mapRow(rs);
            }
        });
    }

    public<T> T query(DataSource dataSource, ResultSetMapper<T> resultSetMapper) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(this.query)) {
            ResultSet rs = stmt.executeQuery();
            return resultSetMapper.mapResultSet(rs);
        } catch (SQLException sql) {
            throw new SqlQueryException(sql);
        }
    }

    public void setStatement(DataSource dataSource) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(this.query, Statement.RETURN_GENERATED_KEYS)) {
            this.statement = stmt;
        } catch (SQLException sql) {
            throw new SqlQueryException(sql);
        }
    }

    public void setString(int colIndex, String value) {
        if (this.statement == null) {
            throw new RuntimeException("Statement not prepared!");
        }
        try {
            this.statement.setString(colIndex, value);
        } catch (SQLException e) {
            throw new SqlQueryException(e);
        }
    }

    public Integer execute() {
        if (this.statement == null) {
            throw new RuntimeException("Statement not prepared!");
        }

        try {
            this.statement.executeUpdate();
            ResultSet rs = this.statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new SqlQueryException(e);
        }
        return null;
    }

}
