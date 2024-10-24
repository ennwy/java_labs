import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberOperations {

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(10);       
        numbers.add(20.5);    
        numbers.add(30);       
        numbers.add(40.7);    
        numbers.add(50);
        numbers.add(60.3);
        numbers.add(70);       
        numbers.add(80.1);    
        numbers.add(90);       
        numbers.add(100.9);    

        
        System.out.println("1. Всі числа: " + numbers);

        System.out.print("Числа у форматі цілих чисел: ");
        for (Number num : numbers) {
            System.out.print(String.format("%d ", num.intValue()));
        }
        System.out.println();

        System.out.print("Числа у форматі дробних чисел з 2 знаками після коми: ");
        for (Number num : numbers) {
            System.out.print(String.format("%.2f ", num.doubleValue()));
        }
        System.out.println();

        List<Integer> integerNumbers = new ArrayList<>();
        List<Double> doubleNumbers = new ArrayList<>();

        for (Number num : numbers) {
            if (num instanceof Integer) {
                integerNumbers.add((Integer) num);
            } else if (num instanceof Double) {
                doubleNumbers.add((Double) num);
            }
        }

        System.out.println("Цілі числа: " + integerNumbers);
        System.out.println("Дробні числа: " + doubleNumbers);

        double product = 1.0;
        for (int i = 0; i < 5; i++) {
            product *= numbers.get(i).doubleValue();
        }
        System.out.println("3. Добуток перших п'яти чисел: " + product);

        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        System.out.println("2. Сума всіх чисел: " + sum);

        BigDecimal bigDecimal1 = new BigDecimal("123.45");
        BigDecimal bigDecimal2 = new BigDecimal("67.89");
        BigDecimal result = bigDecimal1.multiply(bigDecimal2);
        System.out.println("Результат множення BigDecimal: " + result);
    }
}
