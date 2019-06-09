package system_thinking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServerTest {
    @InjectMocks
    private Server testee;

    @Test
    public void whenAnswerToIsNullThenResponseShouldBeSimpleOk() {
        String response = testee.answer(null, null, null, null, null, null);
        assertEquals("response", "", response);
    }

    @Test
    public void whenAnswerToIsEmptyThenResponseShouldBeSimpleOk() {
        String response = testee.answer("", "", "", "", "", "");
        assertEquals("response", "", response);
    }

//    @Test
//    public void whenAnswerToIsNotEmptyhenResponseShouldBeOkWithName() {
//        String response = testee.answer("{\"string\": \"foo\"}");
//        assertEquals("response", "{\"string\": \"foo\"}" , response);
//    }
}
