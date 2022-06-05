package osmanfindik.ibnulcevzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osmanfindik.ibnulcevzi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
