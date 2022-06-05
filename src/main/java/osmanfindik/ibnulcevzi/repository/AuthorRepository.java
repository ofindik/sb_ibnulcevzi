package osmanfindik.ibnulcevzi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osmanfindik.ibnulcevzi.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}