import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    @Test
    void testMinMax() {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 3);
        assertEquals(1, NumberProcessor.getMin(numbers));
        assertEquals(4, NumberProcessor.getMax(numbers));
    }

    @Test
    void testSumMult() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        assertEquals(10, NumberProcessor.getSum(numbers));
        assertEquals(24, NumberProcessor.getMult(numbers));
    }

    List<Integer> generateListByCount(int count){
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            largeList.add(i);
        }

        return largeList;
    }

    @Test
    void testPerformance() {
        // Генерируем список с 5 млн. чисел
        List<Integer> largeList = generateListByCount(5_000_000);

        long startTime = System.currentTimeMillis();

        // Выполняем операции
        NumberProcessor.getMin(largeList);
        NumberProcessor.getMax(largeList);
        NumberProcessor.getSum(largeList);
        NumberProcessor.getMult(largeList);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Время выполнения для 5 млн. чисел: " + duration + " мс");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void failedTst() throws InterruptedException {
        Thread.sleep(7777);
        List<Integer> numbers = Arrays.asList(11,22,33,44);
        assertEquals(2, NumberProcessor.getMult(numbers));
    }
}