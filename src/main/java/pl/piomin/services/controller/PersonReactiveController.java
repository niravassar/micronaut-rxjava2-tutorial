package pl.piomin.services.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.services.model.Gender;
import pl.piomin.services.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller("/persons/reactive")
@Validated
public class PersonReactiveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonReactiveController.class);

    List<Person> persons = new ArrayList<>();

    public PersonReactiveController() {
        persons.add(new Person(1, "Name01", "Surname01", 11, Gender.MALE));
        persons.add(new Person(2, "Name02", "Surname02", 22, Gender.MALE));
        persons.add(new Person(3, "Name03", "Surname03", 33, Gender.MALE));
        persons.add(new Person(4, "Name04", "Surname04", 44, Gender.MALE));
        persons.add(new Person(5, "Name05", "Surname05", 55, Gender.MALE));
        persons.add(new Person(6, "Name06", "Surname06", 66, Gender.MALE));
        persons.add(new Person(7, "Name07", "Surname07", 77, Gender.MALE));
        persons.add(new Person(8, "Name08", "Surname08", 88, Gender.MALE));
        persons.add(new Person(9, "Name09", "Surname09", 99, Gender.MALE));
    }

    @Post
    public Single<Person> add(@Body Person person) {
        person.setId(persons.size() + 1);
        persons.add(person);
        return Single.just(person);
    }

    @Get("/{id}")
    public Maybe<Person> findById(@PathVariable Integer id) {
        return Maybe.just(persons.stream().filter(person -> person.getId().equals(id)).findAny().get());
    }

    @Get(value = "/stream", produces = MediaType.APPLICATION_JSON_STREAM)
    public Flowable<Person> findAllStream() {
        return Flowable.fromIterable(persons).doOnNext(person -> LOGGER.info("Server emit {}", person));
    }

    @Get(value = "/stream/callable", produces = MediaType.APPLICATION_JSON_STREAM)
    public Flowable<Person> findAllStreamWithCallable() {
        return Flowable.fromCallable(() -> {
           int r = new Random().nextInt(100);
           Person p = new Person(1, "Name" + r, "Surname"+r, r, Gender.MALE);
           return p;
        }).doOnNext(person -> LOGGER.info("Server emit {}", person))
                .repeat(9);
    }
}
