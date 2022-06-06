package osmanfindik.ibnulcevzi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.repository.BookRepository;

import java.util.List;
import java.util.Optional;

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

	public void addNewBook (Book book) {
		Optional<Book> bookOptional = bookRepository.findBookByName (book.getName ());
		if (bookOptional.isPresent ()) {
			throw new IllegalStateException ("Book exists");
		}
		bookRepository.save (book);
	}
}
