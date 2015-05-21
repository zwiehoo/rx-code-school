package pl.beta.codeschool.rx;

import rx.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operators {
    public static void main(String[] args) {
        // filter
        List<String> strings = Arrays.asList("ala", "ma", "kota", "grzyb", "grzyboski");
        Observable<String> filter = Observable.from(strings).filter(value -> value.length() == 3);
        filter.subscribe(System.out::println);

        // map
        Observable.from(strings).map(value -> value.toUpperCase()).subscribe(System.out::println);
        Observable.from(strings).map(value -> value.length()).subscribe(System.out::println);

        // reduce
        Observable.from(Arrays.asList(1, 2, 3, 4, 5)).reduce((a,b) -> a + b).subscribe(System.out::println);

        // flatMap
        Observable.from(strings).flatMap(value -> {
            ArrayList<String> objects = new ArrayList<>();
            objects.add(value);
            objects.add(value);
            objects.add(value);
            objects.add(value);
            return Observable.from(objects);
        }).subscribe(System.out::println);

        // zip
        Observable<String> fromStrings = Observable.from(strings);
        Observable<Integer> ints = Observable.from(Arrays.asList(1, 2, 3, 4));

        Observable.zip(fromStrings, ints, (a, b) -> a + " : " + b).subscribe(System.out::println);
    }
}
