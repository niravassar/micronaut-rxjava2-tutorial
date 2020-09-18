package pl.piomin.services.controller;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.services.model.Gender;
import pl.piomin.services.model.Person;

import java.util.ArrayList;
import java.util.List;

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

}
