import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
//        RestAssured.port = Integer.valueOf(51167);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";

        Book book = new Book("121212","Book 121212", 18.95, "Kushal Shrestha");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        Book bookPostmanTest = new Book("111111","Book 111111", 18.95, "Kushal Shrestha");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
    }

    @AfterClass
    public static void cleanup(){
        given()
                .when()
                .delete("books/121212");
    }

    @Test
    public void testGetBookByISBN() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
    }

    @Test
    public void testDeleteByISBN() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().delete("/books/878").then()
                .statusCode(204); //No Content
        // Invalid case
        // Non existing book
        given()
                .contentType("application/json")
                .body(book)
                .when().delete("/books/234324").then()
                .statusCode(404)
                .body("errorMessage", equalTo("Book with isbn = 234324 is not available"));
        given()
                .contentType("application/json")
                .body(book)
                .when().delete("/books/234324").then()
                .statusCode(404);
    }

    @Test
    public void testAddBooks() {
        String isbn="3453325";
        String title="Book 3";
        double price=54.23;
        String author="Kushal Shrestha";
        Book book = new Book(isbn, title, price, author);


        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200)
                .body("isbn", equalTo(isbn))
                .body("title", equalTo(title))
                .body("author", equalTo(author));
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
    }

    @Test
    public void testUpdateBook() {
        String invalidIsbn="9892";
        String isbn="312532";
        String title="Book 3";
        double price=54.23;
        String author="Kushal Shrestha";
        Book book = new Book(isbn, title, price, author);
        Book updateBook = new Book(isbn, "Jungle Book", price, author);
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200)
                .body("isbn", equalTo(isbn))
                .body("title", equalTo(title))
                .body("author", equalTo(author));
        // Valid case
        given()
                .contentType("application/json")
                .body(updateBook)
                .when().put("/books/"+isbn).then()
                .statusCode(200)
                .body("isbn", equalTo(isbn))
                .body("title", equalTo("Jungle Book"));

        //Invalid case, ISBN not exist
        given()
                .contentType("application/json")
                .body(book)
                .when().put("/books/"+invalidIsbn).then()
                .statusCode(200)
                .body("data", equalTo(null));


        //cleanup
        given()
                .contentType("application/json")
                .body(book)
                .when().delete("/books/"+isbn).then()
                .statusCode(204);
        given()
                .contentType("application/json")
                .body(book)
                .when().delete("/books/"+invalidIsbn).then()
                .statusCode(404);


    }

    @Test
    public void testGetAllBooks() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        Book book1 = new Book("8781","Book 1231", 181.95, "Allen Smith");

        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books").then()
                .statusCode(200);

        // test getting the book
        given()
                .when()
                .get("books")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .body("books.isbn",hasItems("878","8781"))
                .body("books.author",hasItems(book.getAuthor(), book1.getAuthor()));

        //cleanup
        given().when().delete("books/"+book.getIsbn());
        given().when().delete("books/"+book1.getIsbn());

    }






}
