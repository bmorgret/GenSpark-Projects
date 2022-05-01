package com.company.humansvsgoblinsgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class GUIController {
    public Game game = new Game();
    @FXML
    public GridPane gridPane;

    public void initialize(){
        game.populateLand(gridPane);
    }

    @FXML
    protected void onKeyPressed(KeyEvent event) {
        String state = "Play";
        switch (event.getCode()) {
            case LEFT:case KP_LEFT:
                state = Game.turn(gridPane, Direction.West);
                break;
            case RIGHT:case KP_RIGHT:
                state = Game.turn(gridPane, Direction.East);
                break;
            case UP:case KP_UP:
                state = Game.turn(gridPane, Direction.North);
                break;
            case DOWN:case KP_DOWN:
                state = Game.turn(gridPane, Direction.South);
                break;
            default:
                break;
        }
        if(state.equals("Won")||state.equals("Lost")){
            PlayAgainPopup playAgainPopup = new PlayAgainPopup();
            Stage playAgainStage = new Stage();
            playAgainPopup.start(playAgainStage);
        }
    }
}