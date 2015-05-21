package pl.beta.codeschool.rx;

import rx.Observable;

public class ErrorHandling {
    public static void main(String[] args) {
        Observable<Integer> observableWithError = Observable.range(0, 10).map(value -> {
            System.out.println("Computing for " + value);

            if (value == 5) {
                throw new RuntimeException("test");
            }

            return value * value;
        });

        observableWithError
                .subscribe(
                        System.out::println
                );
    }
}
