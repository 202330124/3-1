package chapter10;

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

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public class MemberRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member(
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getTimestamp("REGDATE").toLocalDateTime()
            );

            member.setId(rs.getLong("ID"));
            return member;
        }
    }

    public Member selectByEmail(String email) {
        List<Member> result = jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE EMAIL = ?",
                new MemberRowMapper(),
                email
        );

        return result.isEmpty() ? null : result.get(0);
    }

    public List<Member> selectAll() {
        List<Member> result = jdbcTemplate.query(
                "SELECT * FROM MEMBER",
                new MemberRowMapper()
        );

        return result;
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
        return count;
    }

    public void update(Member member) {
        jdbcTemplate.update("UPDATE MEMBER SET NAME = ?, PASSWORD = ? WHERE EMAIL = ?", member.getName(), member.getPassword(), member.getEmail());
    }

    public Long insert(Member member) {
        // jdbcTemplate.update("INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) VALUES (?, ?, ?, NOW())", member.getEmail(), member.getPassword(), member.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) VALUES (?, ?, ?, NOW())", new String[]{"ID"}
                        );

                        ps.setString(1, member.getEmail());
                        ps.setString(2, member.getPassword());
                        ps.setString(3, member.getName());

                        return ps;
                    }
                }, keyHolder
        );

        Number key = (Number) keyHolder.getKey();
        member.setId(key.longValue());
        System.out.println("Key: " + key);

        return null;
    }
}