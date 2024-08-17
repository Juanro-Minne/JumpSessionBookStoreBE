package retro.rabbit.jumpsessionbe.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retro.rabbit.jumpsessionbe.Models.Book;
import retro.rabbit.jumpsessionbe.Models.UserBooks;
import retro.rabbit.jumpsessionbe.Services.BookService;
import retro.rabbit.jumpsessionbe.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;
    private UserBooks userbooks;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get-books")
    public List<Book> getAllAdmins() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get-book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete-book/{id}")
    public void deleteBook(@PathVariable Long id) {

         bookService.deleteBook(id);
    }

    @PostMapping("/create-book")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
