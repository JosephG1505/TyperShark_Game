
package typershark_game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TyperShark_Game extends Application {
    
    @Override
    public void start(Stage stage) {
        Oceano organizador = new Oceano();
        //Shark k = new Shark(1);
        Scene scene = new Scene(organizador.getOceano(), 1000, 900);
        //Scene scene = new Scene(k.getPane(), 1000, 900);
        stage.setScene(scene);
        stage.setTitle("TypeShark!");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
