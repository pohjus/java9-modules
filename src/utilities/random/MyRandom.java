package random;
import java.util.*;

import datapackage.*;
import java.util.stream.*;
public interface MyRandom {
    public String getRandomWord(String... args);


    public static MyRandom getInstance() {
        ServiceLoader<MyRandom> services = ServiceLoader.load(MyRandom.class);
        return services.findFirst().get();
    }


    public default List<Person> getRandomListOfPeopleWithNames(String... args) {
        List<Person> people = Arrays.stream(args).map(name -> new Person(name)).collect(Collectors.toList());
        Collections.shuffle(people);
        return people;
    }
}