package osmanfindik.ibnulcevzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osmanfindik.ibnulcevzi.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<Book> findBookByName (String name);
}
