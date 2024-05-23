import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    @Test
    void testMinMax() {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        assertEquals(1, NumberProcessor._min(numbers));
        assertEquals(4, NumberProcessor._max(numbers));
    }

    @Test
    void testSumMult() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertEquals(10, NumberProcessor._sum(numbers));
        assertEquals(24, NumberProcessor._mult(numbers));
    }

    @Test
    void testPerformance() {
        // Генерируем список с 5 млн. чисел
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < 5_000_000; i++) {
            largeList.add(i);
        }

        long startTime = System.currentTimeMillis();

        // Выполняем операции
        NumberProcessor._min(largeList);
        NumberProcessor._max(largeList);
        NumberProcessor._sum(largeList);
        NumberProcessor._mult(largeList);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Время выполнения для 5 млн. чисел: " + duration + " мс");
    }
}