import java.util.function.IntPredicate;


// Класс NonPrimeCounter подсчитывает количество непростых чисел в массиве.

class NonPrimeCounter implements Accumulator {
    
    // Метод fold подсчитывает количество непростых чисел в массиве.
    @Override
    public int fold(int[] arr) {
        // Лямбда-выражение для проверки числа на непростоту
        IntPredicate isNonPrime = (int num) -> {
            if (num <= 1) return true;
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) return true;
            }
            return false;
        };

        int count = 0;
        for (int num : arr) {
            if (isNonPrime.test(num)) count++;
        }
        return count;
    }
}