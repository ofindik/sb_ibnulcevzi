package osmanfindik.ibnulcevzi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import osmanfindik.ibnulcevzi.model.Author;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.model.Status;
import osmanfindik.ibnulcevzi.repository.AuthorRepository;
import osmanfindik.ibnulcevzi.repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.Month.FEBRUARY;

@Configuration
public class LibraryConfig {

	@Bean
	CommandLineRunner commandLineRunner (BookRepository bookRepository, AuthorRepository authorRepository) {
		return args -> {
			Author author1 = new Author ("Test Author 1");
			authorRepository.save (author1);
			Author author2 = new Author ("Test Author 2");
			authorRepository.save (author2);
			Book book1 = new Book (
				"Test Book 1",
				Status.AVAILABLE,
				LocalDate.of (2022, FEBRUARY, 5)
			);
			book1.getAuthors ().add (author1);
			book1.getAuthors ().add (author2);
			bookRepository.save (book1);
			Book book2 = new Book (
				"Test Book 2",
				Status.AVAILABLE,
				LocalDate.of (2021, FEBRUARY, 25)
			);
			book2.getAuthors ().add (author2);
			bookRepository.save (book2);
		};
	}
}
