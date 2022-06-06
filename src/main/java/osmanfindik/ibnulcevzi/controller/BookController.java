package osmanfindik.ibnulcevzi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import osmanfindik.ibnulcevzi.model.Book;
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
}
