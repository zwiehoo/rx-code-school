package pl.beta.codeschool.rx;

import rx.Observable;

public class SlowConsumer {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();

        System.out.println("Start");

        Observable.range(0, 5)
                .map(value -> slowComputation(value))
                .subscribe(value -> System.out.println("value = " + value));

        System.out.println("End");
        time = System.currentTimeMillis() - time;
        System.out.println("time = " + time);
    }

    private static Integer slowComputation(Integer value) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = value * value;
        System.out.println("Computing " + result + " in thread" + Thread.currentThread().getName());
        return result;
    }
}
