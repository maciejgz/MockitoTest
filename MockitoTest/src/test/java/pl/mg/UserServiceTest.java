package pl.mg;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import pl.mg.mockito.service.UserService;

public class UserServiceTest {


    @Mock
    UserService userService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /** 
     * Zwracanie konkretnej wartości
     */
    @Test
    public void returnExactValue() {
        // drugi sposób na zamockowanie klasy
        UserService userService = Mockito.mock(UserService.class);
        when(userService.getUniqueInt()).thenReturn(50);
        assertEquals(50, userService.getUniqueInt());
    }

    /**
     * rzucanie błędu przy wywołaniu
     */
    @Test(expected = NullPointerException.class)
    public void testForNullPointerException() {
        when(userService.getUniqueInt()).thenThrow(new NullPointerException());
        userService.getUniqueInt();
    }

    @Test
    public void verifyNumebrOfExecutions() {
        userService.stringTestMethod("test");
        //weryfikacja czy metoda została wykonana na obiekcie z konkretnym parametrem
        verify(userService).stringTestMethod("test");

        userService.getUniqueInt();
        userService.getUniqueInt();
        //weryfikacja ile razy została wykonana metoda
        verify(userService, times(2)).getUniqueInt();

    }

}
