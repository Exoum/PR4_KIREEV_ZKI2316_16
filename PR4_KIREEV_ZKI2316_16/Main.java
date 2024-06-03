import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = validateIntInput(scanner, 1, 50);

        // Валидация размера массива
        if (size <= 0) {
            System.out.println("Размер массива должен быть больше нуля.");
        }

        int[] arr = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            if (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Очистка буфера сканера
                i--; // Повторный запрос текущего элемента массива
            }
        }

        scanner.close();

        // Создание экземпляров классов
        PrimeCounter primeCounter = new PrimeCounter();
        NonPrimeCounter nonPrimeCounter = new NonPrimeCounter();

        // Вывод результатов
        System.out.println("Количество простых чисел: " + primeCounter.fold(arr));
        System.out.println("Количество непростых чисел: " + nonPrimeCounter.fold(arr));
    }

    protected static int validateIntInput(Scanner scanner, int min, int max) {
        int input;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Пожалуйста, введите число:");
                scanner.next(); // очистка буфера ввода
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Число вне допустимого диапазона. Пожалуйста, введите число от " + min + " до " + max + ":\n");
            }
        } while (input < min || input > max);
        return input;
    }

}