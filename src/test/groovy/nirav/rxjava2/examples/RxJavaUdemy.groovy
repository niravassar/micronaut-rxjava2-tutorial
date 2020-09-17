package nirav.rxjava2.examples

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

class RxJavaUdemy extends Specification {

    private static final Logger LOGGER = LoggerFactory.getLogger(RxJavaUdemy)

    void 'observable just'() {
        when:
        Observable.just("a", "b", "c", "e", "f", "g", "h", "i", "j")
            .subscribe(new Observer<String>() {
                @Override
                void onSubscribe(@NonNull Disposable d) {
                    LOGGER.info("onSubscribe")
                }

                @Override
                void onNext(@NonNull String s) {
                    LOGGER.info("onNext -> {}", s)
                }

                @Override
                void onError(@NonNull Throwable e) {
                    LOGGER.info("onError -> {}", e.getMessage())
                }

                @Override
                void onComplete() {
                    LOGGER.info("onSubscribe")
                }
            })

        then: "result is returned"
            1 == 1
    }

    void 'observable using create'() {
        when:

        List<Shape> shapes = RxUtils.shapes(3)
        Observable.create( new ObservableOnSubscribe<Object>() {
            @Override
            void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Exception {
                try {
                    shapes.forEach(emitter.&onNext)
                } catch(Exception e) {
                    emitter.onError(e)
                }
                emitter.onComplete()
            }
        }).subscribe( new DemoObserver())

        then: "result is returned"
        1 == 1
    }

    void 'buffer operator'() {
        when:
        Observable.fromIterable(RxUtils.shapes(10))
            .buffer(3)
            .subscribe(new DemoObserver())

        then:
        1 == 1
    }

    void 'map operator'() {
        when:
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .map({ integer -> integer * 2 })
                .subscribe(new DemoObserver())

        then:
        1 == 1
    }

    void 'scan operator'() {
        when:
        Observable<String> myObservable = Observable.just("a", "b", "c", "d", "e");
        myObservable.scan({ x, y -> x + y })
                .subscribe(System.out.&println);

        then:
        1 == 1
    }

}
