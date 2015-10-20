package edu.ksu.swe6633.finalproj.home;


import edu.ksu.swe6633.finalproj.config.database.DbSchema;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<HelloWorldMessage> test() {
        Statement statement = null;
        String query =
            "select hw.helloId," +
            "       hw.message" +
            "  from #schema#.hello_world hw";

        List<HelloWorldMessage> results = new ArrayList<>();

        try {
            statement = dataSource.getConnection().createStatement();
            //The schema we're using is provided by the annotation above, we replace it here so our query will run.
            ResultSet rs = statement.executeQuery(query.replace("#schema#", dbSchema));
            while (rs.next()) {
                results.add(new HelloWorldMessage(rs.getInt("helloId"), rs.getString("message")));
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            //Ew, sorry
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
