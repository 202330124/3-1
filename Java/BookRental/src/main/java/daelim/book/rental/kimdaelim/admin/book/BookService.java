package daelim.book.rental.kimdaelim.admin.book;

import daelim.book.rental.kimdaelim.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    final static public int REGISTER_BOOK_SUCCESS = 1;
    final static public int REGISTER_BOOK_FAIL = -1;

    @Autowired
    private BookDao bookDao;

    public int registerBook(BookVo bookVo) {
        System.out.println("REGISTER BOOK");

        int result = bookDao.addBook(bookVo);

        if(result > 0) {
            return REGISTER_BOOK_SUCCESS;
        } else {
            return REGISTER_BOOK_FAIL;
        }
    }
}