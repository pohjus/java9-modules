
package mypackage.gui;

import random.MyRandom;

import javafx.application.*;
import javafx.event.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import datapackage.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import javafx.collections.*;
import java.util.stream.Collectors;

public class Main extends Application {

    private ObservableList<String> names;
    private ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    public void fetchAsync() {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/people/"))
                .build();
        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        response.thenAccept(res -> parse(res.body()));
    }

    public void parse(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            People p = objectMapper.readValue(json, People.class);

            List<Person> sortedList = p.results.stream()
                                       .sorted(Comparator.comparingDouble(Person::getBmi))
                                       .collect(Collectors.toList());

            Platform.runLater(() -> {
                sortedList.forEach(person -> names.add(person.getName() + " bmi = " + person.getBmi()));
            });
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) {

        // MyRandom random = MyRandom.getInstance();


        // primaryStage.setTitle("GUI App");
        // String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink"};

        // Button button = new Button();
        // final StackPane layout = new StackPane(button);

        // button.setText("Click Me!");
        // // button.setOnAction((e) -> layout.setStyle("-fx-background-color: " + random.getRandomWord(colors)));

        // button.setOnAction(this::fetchAsync);

        // primaryStage.setScene(new Scene(layout, 300, 250));
        // primaryStage.show();


        names = FXCollections.observableArrayList();
        listView = new ListView<String>();
        listView.setItems(names);
        primaryStage.setTitle("Star Wars API");
        primaryStage.setScene(new Scene(listView, 300, 250));
        primaryStage.show();
        fetchAsync();

    }
}