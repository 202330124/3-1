package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AdminAccountDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AdminAccountDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int insertAccount(AdminAccountVo adminAccountVo) {
        List<String> args = new ArrayList<>();
        String sql = "INSERT INTO TB_ADMIN_ACCOUNT (";

        if(adminAccountVo.getId().equals("system")) {
            sql += "approval, ";
            args.add("1");
        }

        sql += "id, ";
        args.add(adminAccountVo.getId());

        sql += "password, ";
        // args.add(adminAccountVo.getPassword());
        args.add(bCryptPasswordEncoder.encode(adminAccountVo.getPassword()));

        sql += "name, ";
        args.add(adminAccountVo.getName());

        sql += "gender, ";
        args.add(adminAccountVo.getGender());

        sql += "part, ";
        args.add(adminAccountVo.getPart());

        sql += "position, ";
        args.add(adminAccountVo.getPosition());

        sql += "email, ";
        args.add(adminAccountVo.getEmail());

        sql += "phone, ";
        args.add(adminAccountVo.getPhone());

        sql += "regDate, modDate) ";

        if(adminAccountVo.getId().equals("system")) {
            sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
        } else {
            sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
        }

        int result = -1;

        try {
            result = jdbcTemplate.update(sql, args.toArray());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean existsAccount(String id) {
        String sql = "SELECT COUNT(*) FROM TB_ADMIN_ACCOUNT WHERE id = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return result > 0;
    }

    public AdminAccountVo selectAdmin(AdminAccountVo adminAccountVo) {
        String sql = "SELECT * FROM TB_ADMIN_ACCOUNT WHERE id = ? AND approval > 0";
        List<AdminAccountVo> adminAccountVoList = new ArrayList<>();

        try {
            adminAccountVoList = jdbcTemplate.query(sql, new RowMapper<AdminAccountVo>() {
                @Override
                public AdminAccountVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    AdminAccountVo adminAccountVo = new AdminAccountVo();

                    adminAccountVo.setNo(rs.getInt("no"));
                    adminAccountVo.setId(rs.getString("id"));
                    adminAccountVo.setName(rs.getString("name"));
                    adminAccountVo.setPassword(rs.getString("password"));
                    adminAccountVo.setGender(rs.getString("gender"));
                    adminAccountVo.setPart(rs.getString("part"));
                    adminAccountVo.setPosition(rs.getString("position"));
                    adminAccountVo.setEmail(rs.getString("email"));
                    adminAccountVo.setPhone(rs.getString("phone"));
                    adminAccountVo.setRegDate(rs.getString("regDate"));
                    adminAccountVo.setModDate(rs.getString("modDate"));

                    return adminAccountVo;
                }
            }, adminAccountVo.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adminAccountVoList.size() == 0 ? null : adminAccountVoList.get(0);
    }

    public AdminAccountVo selectAdmin(int no) {
        String sql = "SELECT * FROM TB_ADMIN_ACCOUNT WHERE no = ?";
        List<AdminAccountVo> adminAccountVoList = new ArrayList<>();

        try {
            adminAccountVoList = jdbcTemplate.query(sql, new RowMapper<AdminAccountVo>() {
                @Override
                public AdminAccountVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    AdminAccountVo adminAccountVo = new AdminAccountVo();

                    adminAccountVo.setNo(rs.getInt("no"));
                    adminAccountVo.setId(rs.getString("id"));
                    adminAccountVo.setName(rs.getString("name"));
                    adminAccountVo.setPassword(rs.getString("password"));
                    adminAccountVo.setGender(rs.getString("gender"));
                    adminAccountVo.setPart(rs.getString("part"));
                    adminAccountVo.setPosition(rs.getString("position"));
                    adminAccountVo.setEmail(rs.getString("email"));
                    adminAccountVo.setPhone(rs.getString("phone"));
                    adminAccountVo.setRegDate(rs.getString("regDate"));
                    adminAccountVo.setModDate(rs.getString("modDate"));

                    return adminAccountVo;
                }
            }, no);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adminAccountVoList.size() == 0 ? null : adminAccountVoList.get(0);
    }

    public int updateAdminAccount(AdminAccountVo adminAccountVo) {
        String sql = "UPDATE TB_ADMIN_ACCOUNT SET "
                + "name = ?, "
                + "gender = ?, "
                + "part = ?, "
                + "position = ?, "
                + "email = ?, "
                + "phone = ?, "
                + "modDate = NOW() "
                + "WHERE no = ?";

        int result = -1;

        try {
            result = jdbcTemplate.update(sql,
                    adminAccountVo.getName(),
                    adminAccountVo.getGender(),
                    adminAccountVo.getPart(),
                    adminAccountVo.getPosition(),
                    adminAccountVo.getEmail(),
                    adminAccountVo.getPhone(),
                    adminAccountVo.getNo());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}