package interfaces;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * Created by Timbuli Remus on 19.10.2016.
 *
 *      Scale Interface
 */
public interface Scale {

    Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    double SCREEN_WIDTH = bounds.getWidth();
    double SCREEN_HEIGHT = bounds.getHeight();

}
