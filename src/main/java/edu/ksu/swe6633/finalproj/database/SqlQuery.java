package edu.ksu.swe6633.finalproj.database;



import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlQuery {

    private final String query;

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
                //TODO Error handling?
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

}
