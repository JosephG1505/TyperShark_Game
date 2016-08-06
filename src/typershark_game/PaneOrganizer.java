
package typershark_game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class PaneOrganizer {
    
    
    private BorderPane _raiz;
    private TextField nombre;
    private TextField nickName;
    private Button Start;
    private String facil;
    private String normal;
    private String dificil;
    
    
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
        TopCenter.getChildren().addAll(new Separator(),titulo,new Separator(),sbtitulo,new Separator(),this.textNombre());
        return TopCenter;
    }
    
    public HBox textNombre(){
        facil="facil";
        normal="normal";
        dificil="dificil";
        Start= new Button("Start");
        Start.setMaxSize(150, 150);
        Start.setMouseTransparent(false);
        
        HBox TextoNombre = new HBox();
        GridPane ColocarTexto1= new GridPane();
        GridPane ColocarTexto2= new GridPane();
        GridPane ColocarTexto3= new GridPane();
        final ComboBox priorityComboBox = new ComboBox();

        
        Label name = new Label("Nombre: ");
        name.setFont(Font.font("Arial",12));
        nombre= new TextField();
        String UserName = nombre.getText();
        System.out.println(UserName);
                
        Label nickname = new Label ("NickName: ");
        nickname.setFont(Font.font("Arial",12));
        nickName = new TextField();
        nickName.setAlignment(Pos.CENTER);
        String UserNick = nombre.getText();
        System.out.println(UserNick);
        
        ColocarTexto1.add(name,1,0);
        ColocarTexto1.add(nombre, 2, 0);
        
        ColocarTexto2.add(nickname,5,0);
        ColocarTexto2.add(nickName, 6, 0);
        
        priorityComboBox.getItems().addAll(facil,normal,dificil); 
        
       
        TextoNombre.getChildren().addAll(ColocarTexto1,ColocarTexto2,ColocarTexto3,priorityComboBox,Start);
        TextoNombre.setSpacing(40);
        
        return TextoNombre;
            
    }
    
    
    public BorderPane getRoot(){
        return _raiz;
    }
    
   
}
