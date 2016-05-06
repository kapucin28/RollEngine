package main;

import javafx.scene.layout.Pane;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

/**
 * Created by TIMBULI REMUS K@puc!n on 05-May-16.
 */
public class Web extends Pane {

    // Browser variables------------------------------------------------------------------------------------------------
    private WebView webView = new WebView();
    private WebView popup = new WebView();
    private WebEngine engine = webView.getEngine();
    private WebHistory history = engine.getHistory();
    //------------------------------------------------------------------------------------------------------------------

    public Web() {
        popupSetup();
    }

    // Popup method-----------------------------------------------------------------------------------------------------
    private void popupSetup() {
        engine.setCreatePopupHandler((PopupFeatures config) -> {
            popup.setFontScale(0.8);
            return popup.getEngine();
        });
    }
    //------------------------------------------------------------------------------------------------------------------
}
