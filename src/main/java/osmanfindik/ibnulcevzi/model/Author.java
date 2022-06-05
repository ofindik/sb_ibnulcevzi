package osmanfindik.ibnulcevzi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {
	@Id
	@SequenceGenerator(name = "author_sequence", sequenceName = "author_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_sequence")
	private Long id;
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "authors")
	private List<Book> books = new ArrayList<> ();

	public Author () {
	}

	public Author (Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Author (String name) {
		this.name = name;
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

	public List<Book> getBooks () {
		return books;
	}

	public void setBooks (List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString () {
		return "Author{" +
			"id=" + id +
			", name='" + name + '\'' +
			", books=" + books +
			'}';
	}
}
