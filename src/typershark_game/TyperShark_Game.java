
package typershark_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TyperShark_Game extends Application {
    
    @Override
    public void start(Stage stage) {
        PaneOrganizer organizador = new PaneOrganizer();
        Scene scene = new Scene(organizador.getRoot(), 900, 500);
        stage.setScene(scene);
        stage.setTitle("TypeShark!");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
