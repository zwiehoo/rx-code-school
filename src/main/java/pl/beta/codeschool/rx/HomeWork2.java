package pl.beta.codeschool.rx;

import com.google.common.primitives.Chars;
import org.javatuples.Pair;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

public class HomeWork2 {
    public static void main(String[] args) {
        List<String> lines = Arrays.asList("Lorem ipsum dolor sit amet",
                "consectetur adipiscing elit",
                "Proin ac fringilla eros. ",
                "In eu diam sapien. ",
                "Maecenas lobortis vitae neque sed vestibulum.");

        Observable<String> linesObservable = Observable.from(lines);

        // TODO - write simple grep-like pattern matching on stream of strings

        String pattern = "am";

        // TODO - perform simple word count (case insensitive)
        Observable
                .from(lines)
                .map(line -> line.toUpperCase())
                .flatMap(line -> Observable.from(
                                Chars.asList(
                                        line.toCharArray()
                                )
                        )
                )
                .groupBy(value -> value)
                .flatMap(observable ->
                                Observable.zip(
                                        Observable.just(observable.getKey()),
                                        observable.count(),
                                        Pair::new
                                )

                )
                .subscribe(System.out::println);
    }
}
