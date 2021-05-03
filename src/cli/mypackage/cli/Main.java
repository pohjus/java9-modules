
package mypackage.cli;

import java.util.logging.*;
import random.*;
import java.util.*;
import datapackage.*;
import mymathpackage.*;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) {
        MyRandom random = MyRandom.getInstance();
        logger.log(Level.INFO, random.getRandomWord("Hello", "World"));


        List<Person> list = MyRandom.getInstance().getRandomListOfPeopleWithNames("Jack", "Tina", "Paul", "John");
        list.forEach(System.out::println);

        System.out.println(MyMath.abs(-4));

        try {
            fetch();
        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fetch() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/people/"))
                .build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
