package nirav.pl.piomin.services.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.reactivex.Single;
import net.jodah.concurrentunit.Waiter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piomin.services.model.Gender;
import pl.piomin.services.model.Person;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@MicronautTest
public class PersonReactiveControllerTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonReactiveControllerTests.class);

    @Inject
    EmbeddedServer server;

    @Test
    public void testAdd() throws MalformedURLException, TimeoutException, InterruptedException {
        final Waiter waiter = new Waiter();
        final Person person = new Person(null, "Name100", "Surname100", 22, Gender.MALE);
        RxHttpClient client = RxHttpClient.create(new URL("http://" + server.getHost() + ":" + server.getPort()));
        Single<Person> s = client.retrieve(HttpRequest.POST("/persons/reactive", person), Person.class).firstOrError();
        s.subscribe(person1 -> {
            LOGGER.info("Retrieved: {}", person1);
            waiter.assertNotNull(person1);
            waiter.assertNotNull(person1.getId());
            waiter.resume();
        });
        waiter.await(3000, TimeUnit.MILLISECONDS);
    }

//    @Test
//    public void testAdd() throws MalformedURLException, TimeoutException, InterruptedException {
//        final Waiter waiter = new Waiter();
//        final Person person = new Person(null, "Name100", "Surname100", 22, Gender.MALE);
//        RxHttpClient client = RxHttpClient.create(new URL("http://" + server.getHost() + ":" + server.getPort()));
//        Single<Person> s = client.retrieve(HttpRequest.POST("/persons/reactive",person), Person.class).firstOrError();
//    }

}
