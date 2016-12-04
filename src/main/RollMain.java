package main;

import alerts.ExitAlert;
import interfaces.ObjectTitles;
import interfaces.Scale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 *
 *      This is the main class where the stage and scene are created
 */
public class RollMain extends Application implements Scale{

    // Scene & Pane variables-------------------------------------------------------------------------------------------
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane, SCREEN_WIDTH, SCREEN_HEIGHT);
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage) {

        // Scene stylesheet---------------------------------------------------------------------------------------------
        scene.getStylesheets().add(getClass().getResource(ObjectTitles.cssFile).toExternalForm());
        //--------------------------------------------------------------------------------------------------------------

        // Adding RollUI to pane----------------------------------------------------------------------------------------
        pane.getChildren().add(new RollUI());
        //--------------------------------------------------------------------------------------------------------------

        // Stage setup--------------------------------------------------------------------------------------------------
        stage.setTitle(ObjectTitles.stageTitle);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            e.consume();
            new ExitAlert();
        });
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------
}
