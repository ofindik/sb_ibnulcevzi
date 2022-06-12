package osmanfindik.ibnulcevzi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.model.Status;
import osmanfindik.ibnulcevzi.service.BookService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController (BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping
	public List<Book> getBooks () {
		return bookService.getBooks ();
	}

	@PostMapping
	public void registerNewBook (@RequestBody Book book) {
		bookService.addNewBook (book);
	}

	@DeleteMapping(path = "{bookId}")
	public void deleteBook (@PathVariable("bookId") Long bookId) {
		bookService.deleteBook (bookId);
	}

	@PutMapping(path = "{bookId}")
	public void updateBook (@PathVariable("bookId") Long bookId,
	                        @RequestParam(required = false) String name,
	                        @RequestParam(required = false) Status status) {
		bookService.updateBook (bookId, name, status);
	}
}
