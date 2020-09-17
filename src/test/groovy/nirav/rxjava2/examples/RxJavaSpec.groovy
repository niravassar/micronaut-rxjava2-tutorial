package nirav.rxjava2.examples

import io.reactivex.Observable
import spock.lang.Specification

class RxJavaSpec extends Specification {

    void 'return a value'() {
        when:
        String result = ""
        Observable<String> observable = Observable.just("Hello") // provides data
        observable.subscribe({ s -> result = s }) // subscriber handles the data.

        then: "result is returned"
        assert result == "Hello"
    }


    void 'return change the char in values='() {
        when:
        String result = ""
        Observable<String> observable = Observable.just("Hello") // provides data
        observable.subscribe({ s -> result = s.replace("o", "--NIRAV--") }) // subscriber handles the data.

        then: "result is altered"
        assert result == "Hell--NIRAV--"
    }

    void 'observable subscribe with lamda calls'() {
        when:
        String result = ""
        String [] letters = ["a", "b", "c", "d"]
        Observable<String> observable = Observable.fromArray(letters)
        observable.subscribe(
                { i -> result += i },
                Throwable.&printStackTrace,
                { -> result += "_Completed" }
        )

        then:
        result == "abcd_Completed" // this gets added on every onNext and the "_completed" gets add on the completex calls
    }

    void 'observable subscribe with map'() {
        when:
        String result = ""
        List<String> letters = ["a", "b", "c", "d"]
        Observable.fromIterable(letters)
            .map({it.toUpperCase() })
            .subscribe({ letter -> result += letter })

        then:
        result == "ABCD"
    }
}
