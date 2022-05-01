package com.company.humansvsgoblinsgui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-game.fxml"));
        Scene mainscene = new Scene(fxmlLoader.load(), 600, 800);
        mainscene.getRoot().requestFocus();
        stage.setTitle("Humans vs Goblins");
        stage.setScene(mainscene);
        mainscene.getRoot().requestFocus();
        stage.show();
        }
    public static void main(String[] args) {
        launch();
    }
}