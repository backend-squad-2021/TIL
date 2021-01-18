package main.day5.higher_order_function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ClassifierAlpha {
    private final int number;

    public ClassifierAlpha(int number) {
        this.number = number;
    }

    public Predicate<Integer> isFactor() {
        return potentialFactor -> number % potentialFactor == 0;
    }

    public Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        Stream.iterate(1, pod -> pod + 1)
                .limit((long)Math.sqrt(number))
                .filter(isFactor())
                .forEach(pod -> {
                    factors.add(pod);
                    factors.add(number / pod);
                });
        return factors;
    }

    static public int sum(Set<Integer> factors) {
//        return factors.stream().mapToInt(Integer::intValue).sum();
        return factors.stream().reduce(0, Integer::sum);
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }

    public boolean isPrime() {
        Set<Integer> primeSet = new HashSet<Integer>(){ {add(1); add(number);} };
        return number > 1 && factors().equals(primeSet);
    }

    public List<String> findIdentity() {
        List<String> list = new ArrayList<>();
        if (isPerfect()) list.add("perfect");
        if (isAbundant()) list.add("abundant");
        if (isDeficient()) list.add("deficiency");
        if (isPrime()) list.add("prime");
        return list;
    }
}
