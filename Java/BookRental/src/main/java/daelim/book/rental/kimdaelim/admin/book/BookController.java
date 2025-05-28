package daelim.book.rental.kimdaelim.admin.book;

import daelim.book.rental.kimdaelim.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/registerBookForm")
    public String registerBookForm() { return "admin/book/register_book_form"; }

    @GetMapping("/bookDetailForm")
    public String bookDetailForm() { return "admin/book/book_detail_form"; }

    @PostMapping("/registerBookConfirm")
    public String registerBookConfirm(BookVo bookVo) {
        // TODO 도서 등록 처리

        String nextPage = "/admin/book/register_book_ok";

        int result = bookService.registerBook(bookVo);
        if(result <= 0) nextPage = "/admin/book/register_book_ng";

        return nextPage;
    }
}