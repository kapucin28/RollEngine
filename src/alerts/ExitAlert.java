package alerts;

import interfaces.AlertsInterface;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * Created by TIMBULI REMUS K@puc!n on 04-May-16.
 *
 *      This is the alert that will popup when the
 * user will try to exit the program
 */
public class ExitAlert {

    // Alert variable---------------------------------------------------------------------------------------------------
    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION, AlertsInterface.exitMessage,
            ButtonType.OK, ButtonType.CANCEL);
    //------------------------------------------------------------------------------------------------------------------

    // Constructor------------------------------------------------------------------------------------------------------
    public ExitAlert() {
        exitAlert(alert);
    }
    //------------------------------------------------------------------------------------------------------------------

    // Exit method------------------------------------------------------------------------------------------------------
    private void exitAlert(Alert alert) {
        this.alert = alert;
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initStyle(StageStyle.TRANSPARENT);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------
}
