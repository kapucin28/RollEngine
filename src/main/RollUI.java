package main;

import alerts.ExitAlert;
import interfaces.ObjectTitles;
import interfaces.Scale;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebHistory;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 *
 *      This class represents the main GUI where
 * all the graphics are created and managed
 */
class RollUI extends Pane implements Scale{

    // Constructing a web object----------------------------------------------------------------------------------------
    private Web web = new Web();
    //------------------------------------------------------------------------------------------------------------------

    // Pane variables---------------------------------------------------------------------------------------------------
    private final GridPane searchingGrid = new GridPane();
    private final TabPane webPane = new TabPane();
    private Tab tab = new Tab();
    private Tab spawnedTab;
    private Web spawnedWeb;
    private final GridPane root = new GridPane();
    //------------------------------------------------------------------------------------------------------------------

    // Web content user tools variables---------------------------------------------------------------------------------
    private ComboBox<String> showHistory = new ComboBox<>();
    private TextField search = new TextField();
    private final Button exitButton = new Button(ObjectTitles.exitButton);
    private final Button newTab = new Button(ObjectTitles.newTab);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    RollUI() {
        layoutSetup();
        historySetup();
        jumpToSetup();
        searchSetup();
        newTabSetup();
        exitSetup();
    }
    //------------------------------------------------------------------------------------------------------------------

    // Layout setup method----------------------------------------------------------------------------------------------
    private void layoutSetup() {

        // Searching grid setup-----------------------------------------------------------------------------------------
        searchingGrid.setHgap(10);
        searchingGrid.setVgap(10);
        searchingGrid.setPadding(new Insets(0, SCREEN_WIDTH / 3, 0, SCREEN_HEIGHT / 3));
        searchingGrid.add(exitButton, 0, 0);
        searchingGrid.add(showHistory, 1, 0);
        searchingGrid.add(search, 2, 0);
        searchingGrid.add(newTab, 3, 0);
        searchingGrid.setPrefHeight(SCREEN_HEIGHT - 700);
        searchingGrid.setPrefWidth(SCREEN_WIDTH);
        //--------------------------------------------------------------------------------------------------------------

        // Web pane setup-----------------------------------------------------------------------------------------------
        webPane.setPadding(new Insets(0, 50, 0, 50));
        webPane.setPrefHeight(SCREEN_HEIGHT - 100);
        webPane.setPrefWidth(SCREEN_WIDTH - 100);
        //--------------------------------------------------------------------------------------------------------------

        // Root setup---------------------------------------------------------------------------------------------------
        root.add(searchingGrid, 0, 0);
        root.add(webPane, 0, 1);
        getChildren().add(root);
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

    // Collecting web history-------------------------------------------------------------------------------------------
    private void historySetup() {
        web.getHistory().getEntries().addListener((ListChangeListener.Change<? extends WebHistory.Entry> h) -> {
            h.next();
            h.getRemoved().forEach((e) -> showHistory.getItems().remove(e.getUrl()));
            h.getAddedSubList().forEach((e) -> showHistory.getItems().add(e.getUrl()));
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Controlling history----------------------------------------------------------------------------------------------
    private void jumpToSetup() {
        showHistory.setOnAction(e -> {
            int offset = showHistory.getSelectionModel().getSelectedIndex() - web.getHistory().getCurrentIndex();
            web.getHistory().go(offset);
            showHistory.setValue(ObjectTitles.historyTitle);
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Search method----------------------------------------------------------------------------------------------------
    private void searchSetup() {
        search.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                web.getEngine().load(ObjectTitles.webProtocol + search.getText() + ObjectTitles.webDomain);

                tab.setClosable(false);
                tab.setContent(web);
                tab.setText(ObjectTitles.defaultTabTitle);
                webPane.getTabs().add(tab);
                search.clear();
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // New Tab method---------------------------------------------------------------------------------------------------
    private void newTabSetup() {
        newTab.setOnAction(e -> {
            spawnedTab = new Tab();
            spawnedWeb = new Web();
            spawnedWeb.getEngine().load(ObjectTitles.defaultSearchEngine);
            spawnedTab.setText(ObjectTitles.spawnedTabTitle);
            spawnedTab.setContent(spawnedWeb);
            webPane.getTabs().add(spawnedTab);
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Exit method------------------------------------------------------------------------------------------------------
    private void exitSetup() {
        exitButton.setOnAction(e -> {
            e.consume();
            new ExitAlert();
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}