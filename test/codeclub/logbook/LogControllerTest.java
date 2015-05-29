package codeclub.logbook;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

public class LogControllerTest {
	
	private LogController underTest;
	
	@Before
	public void setup() throws IOException {
		MockitoAnnotations.initMocks(this);
		
		underTest = new LogController();
	}
	
	@Test
	public void shouldReturnMessageAndPreviousMessages() throws IOException {
		underTest.log("firstMessage");
		ModelAndView result = underTest.log("secondMessage");
		
		assertThat((String) result.getModel().get("message"), is("firstMessage</br>secondMessage</br>"));
	}
	
	@Test
	public void shouldSetViewToLog() throws IOException {
		ModelAndView result = underTest.log("");
		
		assertThat(result.getViewName(), is("log"));
	}
}
