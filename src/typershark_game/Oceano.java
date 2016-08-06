
package typershark_game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javax.swing.ImageIcon;


public class Oceano {
    ImageView imageView;
     
     //Este VBox debe de ser reemplazado por un Panel que nos ayude a interacturar con otros objetos como el tiburon 
     //y el Buzo hay que seguir investigando
    VBox background = new VBox();


     
    public Oceano(){
        Image defaultImage = new Image(getClass().getResourceAsStream("imagenes/fondomar.jpg"));
        imageView = new ImageView(defaultImage);
        background.getChildren().add(imageView);
    }
    
    public ImageView imagenBackGround(){
        Image newImage = new Image("http://www.fullhdwpp.com/wp-content/uploads/Under-the-sea_www.FullHDWpp.com_www.FullHDWpp.com_-728x409.jpg", true);
        imageView.setImage(newImage);
        return this.imageView;
    }
     
    public VBox getBackground() {
        return background;
    }
     
}
