package osmanfindik.ibnulcevzi.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {
	@Id
	@SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	private Long id;
	private String name;

	@ManyToMany()
	@JoinTable(
		name = "bookAuthors",
		joinColumns = @JoinColumn(name = "book_id"),
		inverseJoinColumns = @JoinColumn(name = "author_id")
	)
	private List<Author> authors = new ArrayList<> ();
	private Status status;
	private LocalDateTime borrowedDateTime;

	@Transient
	private Long borrowDuration;

	public Book () {
	}

	public Book (Long id, String name, Status status, LocalDateTime borrowedDateTime) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.borrowedDateTime = borrowedDateTime;
	}

	public Book (String name, Status status, LocalDateTime borrowedDateTime) {
		this.name = name;
		this.status = status;
		this.borrowedDateTime = borrowedDateTime;
	}

	public Long getId () {
		return id;
	}

	public void setId (Long id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public List<Author> getAuthors () {
		return authors;
	}

	public void setAuthors (List<Author> authors) {
		this.authors = authors;
	}

	public Status getStatus () {
		return status;
	}

	public void setStatus (Status status) {
		this.status = status;
	}

	public LocalDateTime getBorrowedDateTime () {
		return borrowedDateTime;
	}

	public void setBorrowedDateTime (LocalDateTime borrowedDateTime) {
		this.borrowedDateTime = borrowedDateTime;
	}

	public Long getBorrowDuration () {
		return Duration.between (borrowedDateTime, LocalDateTime.now ()).toDays ();
	}

	public void setBorrowDuration (Long borrowDuration) {
		this.borrowDuration = borrowDuration;
	}

	@Override
	public String toString () {
		return "Book{" +
			"id=" + id +
			", name='" + name + '\'' +
			", authors=" + authors +
			", status=" + status +
			", borrowedDateTime=" + borrowedDateTime +
			'}';
	}
}
