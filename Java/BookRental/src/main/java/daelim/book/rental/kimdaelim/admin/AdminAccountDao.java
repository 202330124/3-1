package daelim.book.rental.kimdaelim.admin;

import daelim.book.rental.kimdaelim.admin.account.AdminAccountVo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminAccountDao {
    private JdbcTemplate jdbcTemplate;

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
        args.add(adminAccountVo.getPassword());

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
            sql += "VALUES (?,?,?,?,?,?,?,?,?, NOW(), NOW())";
        } else {
            sql += "VALUES (?,?,?,?,?,?,?,?, NOW(), NOW())";
        }

        System.out.println(sql);

        int result = -1;

        try {
            result = jdbcTemplate.update(sql, args);
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
}