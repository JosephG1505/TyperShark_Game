
package typershark_game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class PaneOrganizer {
    
    
    private BorderPane _raiz;
    
    
    public PaneOrganizer(){
        _raiz=new BorderPane();
        _raiz.setTop(this.setupTitulo());
        
        
    }
    
    
    /**Metodo set que propociona el título de nuestro Pane
     * @return VBox llamado TopCenter*/
    public final VBox setupTitulo(){
        VBox TopCenter = new VBox();
        Label titulo = new Label("Bienvenido al Juego de Teclado más rápido");
        titulo.setFont(Font.font("Century Gothic", 16));
        Label sbtitulo = new Label("TYPESHARK");
        sbtitulo.setFont(Font.font("Century Gothic", 16));
        TopCenter.setAlignment(Pos.CENTER);
        TopCenter.getChildren().addAll(titulo,new Separator(),sbtitulo);
        return TopCenter;
    }
    
   
    
    
    public BorderPane getRoot(){
        return _raiz;
    }
    
   
}
