package nirav.rxjava2.examples

import io.reactivex.Observer
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class DemoObserver implements Observer{

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoObserver)

    @Override
    void onSubscribe(@NonNull Disposable d) {
        LOGGER.info("onSubscribe")
    }

    @Override
    void onNext(@NonNull Object s) {
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
}
