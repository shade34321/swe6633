package edu.ksu.swe6633.finalproj.home;


import edu.ksu.swe6633.finalproj.database.RowMapper;
import edu.ksu.swe6633.finalproj.database.SqlQuery;
import edu.ksu.swe6633.finalproj.config.database.DbSchema;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MySqlHelloDao implements HelloDao {

    private final DataSource dataSource;
    private final String dbSchema;

    @Inject
    public MySqlHelloDao(DataSource dataSource, @DbSchema String dbSchema) {
        this.dataSource = dataSource;
        this.dbSchema = dbSchema;
    }

    @Override
    public HelloWorldMessage test() {
        Statement statement = null;

        SqlQuery query = new SqlQuery(
            "select hw.helloId," +
            "       hw.message" +
            "  from #schema#.hello_world hw"
            .replace("#schema#", dbSchema)  //The schema we're using is provided by the annotation above, we replace it here so our query will run.
        );

        return query.queryForObject(dataSource, new RowMapper<HelloWorldMessage>() {
            @Override
            public HelloWorldMessage mapRow(ResultSet rs) throws SQLException {
                String msg = rs.getString("message");
                int id = rs.getInt("helloId");
                return new HelloWorldMessage(id, msg);
            }
        });
    }
}
