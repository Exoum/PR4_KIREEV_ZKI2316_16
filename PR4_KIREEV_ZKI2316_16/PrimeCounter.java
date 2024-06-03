import java.util.function.IntPredicate;


// Класс PrimeCounter подсчитывает количество простых чисел в массиве.
class PrimeCounter implements Accumulator {
        
    // Метод fold подсчитывает количество простых чисел в массиве.
    @Override
    public int fold(int[] arr) {
        // Лямбда-выражение для проверки числа на простоту
        IntPredicate isPrime = (int num) -> {
            if (num <= 1) return false;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) return false;
            }
            return true;
        };

        int count = 0;
        for (int num : arr) {
            if (isPrime.test(num)) count++;
        }
        return count;
    }
}