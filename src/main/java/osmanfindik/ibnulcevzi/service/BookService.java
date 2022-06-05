package osmanfindik.ibnulcevzi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookService (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getBooks () {
		return bookRepository.findAll ();
	}
}
