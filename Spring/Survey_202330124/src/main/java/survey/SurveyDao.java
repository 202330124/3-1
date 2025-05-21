package survey;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SurveyDao {
    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public class SurveyRowMapper implements RowMapper<Survey> {
        @Override
        public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
            Survey survey = new Survey(
                    rs.getString("Q1"),
                    rs.getString("Q2"),
                    rs.getString("Q3"),
                    rs.getString("RespondentName"),
                    rs.getInt("RespondentAge"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
            );

            survey.setId(rs.getLong("ID"));
            return survey;
        }
    }

    public Survey selectByName(String name){
        List<Survey> result = jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE EMAIL = ?",
                new SurveyRowMapper(),
                name
        );

        return result.isEmpty() ? null : result.get(0);
    }

    public Long insert(Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                        PreparedStatement ps = conn.prepareStatement(
                                "INSERT INTO SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) VALUES(?, ?, ?, ?, ?, NOW())"
                        );

                        ps.setString(1, survey.getPart());
                        ps.setString(2, survey.getTool());
                        ps.setString(3, survey.getSay());
                        ps.setString(4, survey.getName());
                        ps.setInt(5, survey.getAge());

                        return ps;
                    }
                }, keyHolder
        );

        Number key = (Number) keyHolder.getKey();
        survey.setId(key.longValue());
        System.out.println("Key: " + key);

        return null;
    }
}