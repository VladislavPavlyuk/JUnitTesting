package brainacad;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestResultLogger.class)
public class AppTest {
    
    @Test
    public void main_WhenCalled_ExecutesWithoutException() {
        // Проверяем, что метод main выполняется без исключений
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        });
    }
    
    @Test
    public void main_WhenCalledWithArgs_ExecutesWithoutException() {
        // Проверяем, что метод main выполняется без исключений с аргументами
        assertDoesNotThrow(() -> {
            App.main(new String[]{"arg1", "arg2"});
        });
    }
}
