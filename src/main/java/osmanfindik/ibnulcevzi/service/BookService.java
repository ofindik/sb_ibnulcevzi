package osmanfindik.ibnulcevzi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.model.Status;
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
			throw new IllegalStateException ("Book exists.");
		}
		bookRepository.save (book);
	}

	public void deleteBook (Long bookId) {
		boolean exists = bookRepository.existsById (bookId);
		if (!exists) {
			throw new IllegalStateException ("Book with id " + bookId + " does not exist.");
		}
		bookRepository.deleteById (bookId);
	}

	@Transactional
	public void updateBook (Long bookId, String name, Status status) {
		Book book = bookRepository.findById (bookId).orElseThrow (() ->
			new IllegalStateException ("Book with id " + bookId + " does not exist."));
		if (StringUtils.hasLength (name) && !book.getName ().equals (name)) {
			book.setName (name);
		}
		if (null != status && book.getStatus () != status) {
			book.setStatus (status);
		}
	}
}
