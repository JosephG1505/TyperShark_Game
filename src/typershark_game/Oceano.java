
package typershark_game;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javax.swing.ImageIcon;


public class Oceano {
    
    
    private Pane _oceano;
    private Buzo _buzo;
    private ArrayList<String> palabras;
    
    
    public Oceano() {
        
        this._oceano = new Pane();
        this._buzo = new Buzo();
        this.palabras = this._buzo.getPalabras();
    }
    
    public void addShark(Shark _shark){
        _shark.setVelocidad(1);
        _buzo.getTiburones().add(_shark);
        _shark.start();
    
    }

    public Pane getOceano() {
        return _oceano;
    }

    public void setOceano(Pane _oceano) {
        this._oceano = _oceano;
    }

    public Buzo getBuzo() {
        return _buzo;
    }

    public void setBuzo(Buzo _buzo) {
        this._buzo = _buzo;
    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }
    
}
    
//    ImageView imageView;
//     
//     //Este VBox debe de ser reemplazado por un Panel que nos ayude a interacturar con otros objetos como el tiburon 
//     //y el Buzo hay que seguir investigando
//    VBox background = new VBox();
//
//
//     
//    public Oceano(){
//        Image defaultImage = new Image(getClass().getResourceAsStream("imagenes/fondomar.jpg"));
//        imageView = new ImageView(defaultImage);
//        background.getChildren().add(imageView);
//    }
//    
//    public ImageView imagenBackGround(){
//        Image newImage = new Image("http://www.fullhdwpp.com/wp-content/uploads/Under-the-sea_www.FullHDWpp.com_www.FullHDWpp.com_-728x409.jpg", true);
//        imageView.setImage(newImage);
//        return this.imageView;
//    }
//     
//    public VBox getBackground() {
//        return background;
//    }
    
    /*NUEVO*/
    
//     private ImageView imagen;
//     private Timer timer;
//     private Buzo _buceador;
//     private TextField campo = new TextField();
//     private String _entrada;
//     private int puntaje = 0;
//
//    public Oceano() throws IOException {
//        
//        InputStream img = Files.newInputStream(Paths.get("src/typershark/proyect/imagenes/MAIN.jpg"));
//        Image imgJuego = new Image(img);
//        img.close();
//
//        this.imagen = new ImageView(imgJuego);
//        this.imagen.setFitHeight(600);
//        this.imagen.setFitHeight(600);
//        
//        setFocusTraversable(true);
//        
//        campo.setText("Enter");
//        campo.addEventHandler(new keyListener());
//        
//        timer = new Timer();
//        
//        getChildren().addAll(campo);
//        Pane p = new Pane();
//    }

