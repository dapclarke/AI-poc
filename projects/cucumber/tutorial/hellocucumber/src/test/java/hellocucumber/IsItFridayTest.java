package hellocucumber;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IsItFridayTest {

    @Test
    public void testFridayResponse() {
        String result = IsItFriday.isItFriday("Friday");
        assertEquals("TGIF", result);
    }

    @Test
    public void testNonFridayResponse() {
        String result = IsItFriday.isItFriday("Monday");
        assertEquals("Nope", result);
    }

}
