
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


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void fetchAsync(ActionEvent event) {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://swapi.dev/api/people/1/"))
                .build();
        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        response.thenAccept(res -> res.body());
    }


    @Override
    public void start(Stage primaryStage) {

        MyRandom random = MyRandom.getInstance();


        primaryStage.setTitle("GUI App");
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Pink"};

        Button button = new Button();
        final StackPane layout = new StackPane(button);

        button.setText("Click Me!");
        // button.setOnAction((e) -> layout.setStyle("-fx-background-color: " + random.getRandomWord(colors)));

        button.setOnAction(this::fetchAsync);

        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();
    }
}