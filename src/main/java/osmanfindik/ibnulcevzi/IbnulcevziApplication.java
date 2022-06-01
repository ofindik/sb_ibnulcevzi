package osmanfindik.ibnulcevzi;

import com.sun.tools.javac.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.model.Status;

import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@SpringBootApplication
@RestController
public class IbnulcevziApplication {

	public static void main (String[] args) {
		SpringApplication.run (IbnulcevziApplication.class, args);
	}

	@GetMapping
	public List<Book> hello () {
		return List.of (new Book (
			UUID.randomUUID (),
			"Test Book",
			List.of ("Test Author"),
			Status.AVAILABLE,
			LocalDate.of (2022, Month.FEBRUARY, 5)
		));
	}
}
