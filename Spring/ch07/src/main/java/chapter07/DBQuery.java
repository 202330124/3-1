package chapter07;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DBQuery {
    @Autowired
    private DataSource dataSource;

    public int count() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();

            try (
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select count(*) from MEMBER");
            ) {
                rs.next();
                return rs.getInt(1);
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}