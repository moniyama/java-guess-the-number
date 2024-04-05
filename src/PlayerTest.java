import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {
    private final Player human = new HumanPlayer();
    private final Player computer = new ComputerPlayer();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach //  initialize
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    // As the standard output stream is a shared static resource used by other parts of the system, we should take care of restoring it to its original state
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test setName was set correctly using getName")
    void setName() {
        String testName = "Test";
        human.setName(testName);
        assertEquals(testName, human.getName());
    }

    @Test
    @DisplayName("Test getGuesses was getting correctly using addGuesses")
    void getGuesses() {
        human.addGuesses(50);
        human.addGuesses(10);
        human.addGuesses(5);
        human.addGuesses(3);
        int first = human.getGuesses().getFirst();
        int second = human.getGuesses().get(1);
        int third = human.getGuesses().get(2);
        int last = human.getGuesses().getLast();

        assertAll(
                () -> assertEquals(50, first),
                () -> assertEquals(10, second),
                () -> assertEquals(5, third),
                () -> assertEquals(3, last)
        );
    }

    @Test
    @DisplayName("Test askForGuess for human")
    void askForGuess() {
        human.setName("test-name");
        human.askForGuess();
        assertEquals("--- Round: test-name ---\r\ntest-name, enter your guess:", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Computer getName should return 'Computer'")
    void getName() {
        assertEquals("Computer", computer.getName());
    }

    @Test
    @DisplayName("Human makeGuess & computer makeGuess")
    @Disabled
    void makeGuess() {
        human.guesses = new ArrayList<>();
        provideInput("46");

        human.makeGuess();
        assertEquals(46, human.getGuesses().getFirst());

        provideInput("60");
        human.makeGuess();
        assertEquals(60, human.getGuesses().getLast());

//        HumanPlayer mockPlayer = mock(HumanPlayer.class);
//        mockPlayer.guesses
//        doNothing().when(mockPlayer).addGuesses(isA(Integer.class));
//

//        verify(mockPlayer,times(1)).addGuesses(3);

//        mockPlayer.makeGuess();
//        doCallRealMethod().when(mockPlayer).makeGuess();
//        doCallRealMethod().when(mockPlayer).addGuesses(3);
    }
    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}