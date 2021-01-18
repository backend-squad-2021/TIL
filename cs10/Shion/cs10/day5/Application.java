package main.day5.higher_order_function;

import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(2, 100);
        intStream.mapToObj(x -> {
                    System.out.print(x + " : ");
                    return new ClassifierAlpha(x);
                })
                .map(ClassifierAlpha::findIdentity)
                .map(arr -> String.join(", ", arr))
                .forEach(System.out::println);
    }
}
