package daelim.book.rental.kimdaelim.admin.book;

import daelim.book.rental.kimdaelim.BookVo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    public int addBook(BookVo bookVo) {
        List<String> args = new ArrayList<>();
        String sql = "INSERT INTO TB_BOOK (";

        sql += "thumbnail, ";
        args.add(bookVo.getThumbnail());

        sql += "name, ";
        args.add(bookVo.getName());

        sql += "author, ";
        args.add(bookVo.getAuthor());

        sql += "publisher, ";
        args.add(bookVo.getPublisher());

        sql += "publishYear, ";
        args.add(bookVo.getPublish_year());

        sql += "isbn, ";
        args.add(bookVo.getIsbn());

        sql += "callNumber, ";
        args.add(bookVo.getCall_number());

        sql += "rentalAble, ";
        args.add(bookVo.getRental_able());

        sql += "regDate, modDate) ";

        sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

        int result = -1;

        try {
            result = jdbcTemplate.update(sql, args.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}