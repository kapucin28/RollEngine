package main;

import alerts.ExitAlert;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 */
public class RollMain extends Application {

    // Scene & Pane variables-------------------------------------------------------------------------------------------
    private final Pane pane = new Pane();
    private final ImageView imageView = new ImageView("resources/redbackground.jpg");
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final Scene scene = new Scene(pane, bounds.getWidth(), bounds.getHeight());
    //------------------------------------------------------------------------------------------------------------------

    // Main method------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Application.launch(args);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Start method-----------------------------------------------------------------------------------------------------
    public void start(Stage stage) {

        // Scene stylesheet---------------------------------------------------------------------------------------------
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        //--------------------------------------------------------------------------------------------------------------

        // Adding RollUI to pane----------------------------------------------------------------------------------------
        pane.getChildren().add(imageView);
        imageView.setFitWidth(bounds.getWidth());
        imageView.setFitHeight(bounds.getHeight());
        pane.getChildren().add(new RollUI());
        //--------------------------------------------------------------------------------------------------------------

        // Stage setup--------------------------------------------------------------------------------------------------
        stage.setTitle("RollEngine");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
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
