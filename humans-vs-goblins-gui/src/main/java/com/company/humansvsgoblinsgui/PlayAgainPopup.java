package com.company.humansvsgoblinsgui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.application.Application;

// Java program to create a popup and
// add it to the stage

public class PlayAgainPopup extends Application {

    // launch the application
    public void start(Stage stage)
    {
        stage.setTitle("Play Again?");

        // yes button
        Button yesButton = new Button("Yes");
        yesButton.setAlignment(Pos.CENTER);
        EventHandler<ActionEvent> yesEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                System.out.println("yes");
                Game.resetGame();
                stage.close();
            }
        };
        yesButton.setOnAction(yesEvent);

        // no button
        Button noButton = new Button("No");
        noButton.setAlignment(Pos.CENTER);
        TilePane tilepane = new TilePane();
        EventHandler<ActionEvent> noEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                Platform.exit();
                System.out.println("no");
            }
        };
        noButton.setOnAction(noEvent);

        tilepane.getChildren().add(yesButton);
        tilepane.getChildren().add(noButton);
        Scene scene = new Scene(tilepane, 200, 200);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }
}

