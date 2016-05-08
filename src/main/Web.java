package main;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Screen;

/**
 * Created by TIMBULI REMUS K@puc!n on 05-May-16.
 */
public class Web extends Pane {

    // Browser variables------------------------------------------------------------------------------------------------
    private Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    private WebView webView = new WebView();
    private WebView popup = new WebView();
    private WebEngine engine = webView.getEngine();
    private WebHistory history = engine.getHistory();
    //------------------------------------------------------------------------------------------------------------------

    public Web() {
        webViewLayout();
        popupSetup();
    }

    // Web layout method------------------------------------------------------------------------------------------------
    private void webViewLayout() {
        webView.setPrefWidth(bounds.getWidth() - 300);
        webView.setPrefHeight(bounds.getHeight() - 200);
        getChildren().add(webView);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Popup method-----------------------------------------------------------------------------------------------------
    private void popupSetup() {
        engine.setCreatePopupHandler((PopupFeatures config) -> {
            popup.setFontScale(0.8);
            return popup.getEngine();
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    // Getters & Setters------------------------------------------------------------------------------------------------
    public WebEngine getEngine() {
        return engine;
    }

    public WebHistory getHistory() {
        return history;
    }
    //------------------------------------------------------------------------------------------------------------------
}
