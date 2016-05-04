package main;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 */
public class RollMain extends Application {

    // Scene & Pane variables-------------------------------------------------------------------------------------------
    private Pane pane = new Pane();
    private Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private Scene scene = new Scene(pane, bounds.getWidth(), bounds.getHeight());
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage){
        stage.setTitle("RollEngine");
        stage.setScene(scene);
        stage.show();
    }
    //------------------------------------------------------------------------------------------------------------------
}
