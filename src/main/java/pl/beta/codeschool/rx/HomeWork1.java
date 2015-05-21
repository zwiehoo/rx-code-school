package pl.beta.codeschool.rx;

import org.javatuples.Pair;
import rx.Observable;
import rx.observables.MathObservable;

import java.util.Arrays;
import java.util.List;

public class HomeWork1 {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.0, 3.0, 3.4, 2.4, 7.5);
        Observable<Double> doubleObservable = Observable.from(doubles);

        // TODO compute average

        // Solution 1
        doubleObservable
                .map(value -> new Pair<>(1, value))
                .reduce((a,b) -> new Pair<>(a.getValue0() + b.getValue0(), a.getValue1() + b.getValue1()))
                .map(pair -> pair.getValue1() / pair.getValue0())
                .subscribe(System.out::println);

        // Solution 2
        Observable.zip(
                doubleObservable.reduce((a,b) -> a + b),
                doubleObservable.count(),
                (a, b) -> a / b
        ).subscribe(System.out::println);

        // Solution 3 - rxjava-math extension
        MathObservable.from(doubleObservable).averageDouble(val -> val).subscribe(System.out::println);
    }
}
