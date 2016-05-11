package main;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 */
class RollUI extends Pane {

    // Constructing a web object----------------------------------------------------------------------------------------
    private Web web = new Web();
    //------------------------------------------------------------------------------------------------------------------

    // Pane variables---------------------------------------------------------------------------------------------------
    private final Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private final GridPane searchingGrid = new GridPane();
    private final TabPane webPane = new TabPane();
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Web content user tools variables---------------------------------------------------------------------------------
    private ComboBox<String> showHistory = new ComboBox<>();
    private TextField search = new TextField();
    private final Button exit = new Button("Exit");
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    RollUI() {
        layoutSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    private void layoutSetup() {
        searchingGrid.setPrefHeight(bounds.getHeight() - 700);
        searchingGrid.setPrefWidth(bounds.getWidth());
        webPane.setPrefHeight(bounds.getHeight() - 138);
        webPane.setPrefWidth(bounds.getWidth() - 40);
        root.add(searchingGrid, 0, 0);
        root.add(webPane, 0, 1);
        getChildren().add(root);
    }
    //------------------------------------------------------------------------------------------------------------------
}
