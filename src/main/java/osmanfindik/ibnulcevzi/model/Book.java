package osmanfindik.ibnulcevzi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Book {
	private UUID id;
	private String name;
	private List<String> authors;
	private Status status;
	private LocalDate borrowedDate;

	public Book () {
	}

	public Book (UUID id, String name, List<String> authors, Status status, LocalDate borrowedDate) {
		this.id = id;
		this.name = name;
		this.authors = authors;
		this.status = status;
		this.borrowedDate = borrowedDate;
	}

	public Book (String name, List<String> authors, Status status, LocalDate borrowedDate) {
		this.name = name;
		this.authors = authors;
		this.status = status;
		this.borrowedDate = borrowedDate;
	}

	public UUID getId () {
		return id;
	}

	public void setId (UUID id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public List<String> getAuthors () {
		return authors;
	}

	public void setAuthors (List<String> authors) {
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
