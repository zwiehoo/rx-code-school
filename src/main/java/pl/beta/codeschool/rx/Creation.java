package pl.beta.codeschool.rx;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

public class Creation {
    public static void main(String[] args) {
        // just
        Observable<Integer> just = Observable.just(1);
        Observable<String> test = Observable.just("Test");

        just.subscribe(System.out::println);
        just.subscribe(System.out::println);

        test.subscribe(System.out::println);

        // from
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Observable<Integer> integers = Observable.from(list);
        integers.subscribe(System.out::println);

        // create
        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }

                subscriber.onNext("Test1");
                subscriber.onNext("Test2");
                subscriber.onNext("Test3");
                subscriber.onNext("Test4");

                subscriber.onCompleted();
            }
        });
        stringObservable.subscribe(System.out::println);
    }
}
