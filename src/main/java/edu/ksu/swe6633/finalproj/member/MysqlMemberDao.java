package edu.ksu.swe6633.finalproj.member;

import javax.inject.Inject;

import com.mysql.jdbc.Statement;
import edu.ksu.swe6633.finalproj.config.database.DbSchema;
import edu.ksu.swe6633.finalproj.database.ResultSetMapper;
import edu.ksu.swe6633.finalproj.database.RowMapper;
import edu.ksu.swe6633.finalproj.database.SqlQuery;
import edu.ksu.swe6633.finalproj.database.SqlQueryException;
import edu.ksu.swe6633.finalproj.domain.member.CreateMember;
import edu.ksu.swe6633.finalproj.domain.member.Member;
import edu.ksu.swe6633.finalproj.domain.member.MemberRole;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MysqlMemberDao implements MemberDao {
    private final DataSource dataSource;
    private final String dbSchema;

    @Inject
    public MysqlMemberDao(DataSource dataSource, @DbSchema String schema) {
        this.dataSource = dataSource;
        this.dbSchema = schema;
    }

    @Override
    public Member addMember(CreateMember create) {
        String insert =
            "INSERT INTO Member" +
            "(firstName, lastName, role) VALUES" +
            "(?, ?, ?)"
        ;
        Connection connection = null;
        PreparedStatement insertStatement = null;
        Integer mId = null;
        try {
            connection = dataSource.getConnection();
            insertStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, create.getFirstName());
            insertStatement.setString(2, create.getLastName());
            insertStatement.setString(3, create.getMemberRole().name());

            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();

            if (rs.next()) {
                mId = rs.getInt(1);
            }
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new SqlQueryException(ex);
                }
            }
            throw new SqlQueryException(e);
        } finally {
            try {
                insertStatement.close();
            } catch (SQLException e) {
                throw new SqlQueryException(e);
            }
        }



        SqlQuery query = new SqlQuery(
            "SELECT m.memberId," +
            "       m.firstName," +
            "       m.lastName," +
            "       m.role" +
            "  FROM " + this.dbSchema + ".Member m" +
            " WHERE m.memberId = " + mId
        );

        return query.queryForObject(dataSource, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs) throws SQLException {
                return new Member(
                    MemberRole.valueOf(rs.getString("role")),
                    rs.getInt("memberId"),
                    rs.getString("firstName"),
                    rs.getString("lastName")
                );
            }
        });

    }

    @Override
    public List<Member> getMembers() {
        SqlQuery query = new SqlQuery(
            "SELECT m.memberId," +
            "       m.firstName," +
            "       m.lastName," +
            "       m.role" +
            "  FROM " + this.dbSchema + ".Member m"
        );

        return query.queryForList(dataSource, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs) throws SQLException {
                return new Member(
                    MemberRole.valueOf(rs.getString("role")),
                    rs.getInt("memberId"),
                    rs.getString("firstName"),
                    rs.getString("lastName")
                );
            }
        });
    }
}
