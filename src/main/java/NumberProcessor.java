import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberProcessor {

    public static void main(String[] args) {
        try {
            // Чтение чисел из файла
            List<Integer> numbers = readNumbersFromFile("src/numbers.txt");

            // Вычисления
            int min = getMin(numbers);
            int max = getMax(numbers);
            int sum = getSum(numbers);
            long mult = getMult(numbers); // Используем long для предотвращения переполнения

            // Вывод результатов
            System.out.println("Минимальное: " + min);
            System.out.println("Максимальное: " + max);
            System.out.println("Сумма: " + sum);
            System.out.println("Произведение: " + mult);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Чтение чисел из файла в список
    private static List<Integer> readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line != null) {
                String[] numberStrings = line.split(" ");
                for (String numberString : numberStrings) {
                    numbers.add(Integer.parseInt(numberString));
                }
            }
        }
        return numbers;
    }

    // Поиск минимального числа
    public static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    // Поиск максимального числа
    public static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Вычисление суммы чисел
    public static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Вычисление произведения чисел
    public static long getMult(List<Integer> numbers) {
        long product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }
}