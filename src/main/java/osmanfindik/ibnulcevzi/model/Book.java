package osmanfindik.ibnulcevzi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
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
	private LocalDate borrowedDate;

	public Book () {
	}

	public Book (Long id, String name, Status status, LocalDate borrowedDate) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.borrowedDate = borrowedDate;
	}

	public Book (String name, Status status, LocalDate borrowedDate) {
		this.name = name;
		this.status = status;
		this.borrowedDate = borrowedDate;
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

	public LocalDate getBorrowedDate () {
		return borrowedDate;
	}

	public void setBorrowedDate (LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	@Override
	public String toString () {
		return "Book{" +
			"id=" + id +
			", name='" + name + '\'' +
			", authors=" + authors +
			", status=" + status +
			", borrowedDate=" + borrowedDate +
			'}';
	}
}
