package mvc;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<String, Book> bookList = new HashMap<String, Book>();

    public BookController() {
        bookList.put("1-2432432-23",new Book("1-2432432-23", "Rudyard","The Jungle Book", 24.3));
        bookList.put("1-4322311-23",new Book("1-4322311-23", "Hari Bansa Acharya","China Harayeko Manche", 12.1));

    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookList.put(book.getIsbn(), book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        Book b = bookList.get(isbn);
        if (b == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        bookList.put(book.getIsbn(), book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // Delete a book
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = bookList.get(isbn);
        if (book == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        bookList.remove(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    // Get a book by ISBN
    @GetMapping("/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookList.get(isbn);
        if (book == null){
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Book with isbn= " + isbn + " is not available"),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookList.values().stream().collect(Collectors.toList());
    }

    // Search books by author
    @GetMapping(params = "author")
    public ResponseEntity<?> searchBooks(@RequestParam String author) {
        List<Book> bookListByMatchedAuthor = bookList.values().stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
        if (bookListByMatchedAuthor.size() == 0) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book Not Found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List>(bookListByMatchedAuthor, HttpStatus.OK);
    }
}
