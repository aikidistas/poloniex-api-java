package org.aikidistas.highfrequencytrading.experiments;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.SneakyThrows;
import org.aikidistas.highfrequencytrading.App;

public class ReactiveApp implements App {

    public static void main(String[] args) {
        App app = new ReactiveApp();
        app.run();
    }

    @SneakyThrows
    @Override
    public void run() {
        //-----------------------------------------------------
        Flowable.just("Hello world").subscribe(System.out::println);

        //-----------------------------------------------------
        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 3 == 0);
        flow.subscribe(System.out::println);

        //-----------------------------------------------------
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError((new IllegalStateException("Odd millisecond!")));
                    break;
                }
            }
        })
                .subscribe(System.out::println, Throwable::printStackTrace);

        //-----------------------------------------------------
        Flowable.fromCallable(() -> {
            Thread.sleep(1000); // imitate expensive operation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);
        Thread.sleep(2000); // Wait for the flow to finish

    }
}
