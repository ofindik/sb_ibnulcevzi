package osmanfindik.ibnulcevzi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import osmanfindik.ibnulcevzi.model.Book;
import osmanfindik.ibnulcevzi.model.Status;
import osmanfindik.ibnulcevzi.service.BookService;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BookService bookService;

	@Test
	@WithMockUser(username = "admin", password = "password", roles = "USER")
	public void when_There_Are_No_Books_GetBooks_Should_Return_EmptyList () throws Exception {
		when (bookService.getBooks ()).thenReturn (Arrays.asList ());

		mockMvc.perform (get ("/api/v1/books"))
			.andDo (print ())
			.andExpect (status ().isOk ())
			.andExpect (content ().json ("[]"));
	}

	@Test
	@WithMockUser(username = "admin", password = "password", roles = "USER")
	public void when_There_Is_One_Book_GetBooks_Should_Return_List_with_One_Element () throws Exception {
		Book testbook = new Book (1L, "Testbbok", Status.AVAILABLE, LocalDateTime.of (2022, 1, 1, 0, 0, 0));
		when (bookService.getBooks ()).thenReturn (Arrays.asList (testbook));

		mockMvc.perform (get ("/api/v1/books"))
			.andDo (print ())
			.andExpect (status ().isOk ())
			.andExpect (jsonPath ("$.[0].id").value (testbook.getId ()))
			.andExpect (jsonPath ("$.[0].name").value (testbook.getName ()));
	}

	@Test
	@WithMockUser(username = "admin", password = "password", roles = "USER")
	public void when_There_Are_Two_Books_GetBooks_Should_Return_List_with_Two_Elements () throws Exception {
		Book testbook1 = new Book (1L, "Testbbok1", Status.AVAILABLE, LocalDateTime.of (2022, 1, 1, 0, 0, 0));
		Book testbook2 = new Book (2L, "Testbbok2", Status.AVAILABLE, LocalDateTime.of (2022, 1, 1, 0, 0, 0));
		when (bookService.getBooks ()).thenReturn (Arrays.asList (testbook1, testbook2));
		BookController bookController = new BookController (bookService);

		mockMvc.perform (get ("/api/v1/books"))
			.andDo (print ())
			.andExpect (status ().isOk ())
			.andExpect (jsonPath ("$.[0].id").value (testbook1.getId ()))
			.andExpect (jsonPath ("$.[0].name").value (testbook1.getName ()))
			.andExpect (jsonPath ("$.[1].id").value (testbook2.getId ()))
			.andExpect (jsonPath ("$.[1].name").value (testbook2.getName ()));
	}
}
