
package typershark_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.StackPaneBuilder;
import javafx.scene.layout.VBox;
import javax.swing.ImageIcon;


public class Oceano {
    
    
    private Pane _oceano;
    private Shark _shark;
    //private Buzo _buzo;
    private ArrayList<String> palabras;
    private ArrayList<Shark> _tiburones;
    
    
    public Oceano() {
        
        this._oceano = new Pane();
        this.sharkToArray();
        this.addSharktoOcean();
        System.out.println("321123213213213231321213231");

        _oceano.getChildren();
        System.out.println("weiucbiwuegciwucicgiwciuwgeciuwegcwieueiwc");
        //this._buzo = new Buzo();


        
//        _shark.setTiburon(palabras.get(0));
//        _shark.pintar("h");
//        _shark.pintar("e");
        
        //_shark.setPalabra("hola");
        //_shark.listener();
        //addShark(_shark);
        
        //_oceano.getChildren().addAll(_buzo.getImage(),_shark.getPane());
        

    }
    
    public void sharkToArray(){
        loadPalabras();
        this._shark = new Shark(1);
        //_shark.start();
        this._tiburones = new ArrayList<>();
        for(String p : palabras){
            this._shark.setTiburon(p);
            _tiburones.add(_shark);
            System.out.println("shark in the tank");
            
        }
        
    }
    
//    public void addShark(Shark _shark){
//        _shark.setVelocidad(1);
//        //_buzo.getTiburones().add(_shark);
//        _shark.start();
//    
//    }
    
    public void addSharktoOcean(){
        for(Shark s : _tiburones){
            _oceano.getChildren().addAll(s.getPane());
            //_shark.init();
        }
    }

    public Pane getOceano() {
        return _oceano;
    }

    public void setOceano(Pane _oceano) {
        this._oceano = _oceano;
    }

//    public Buzo getBuzo() {
//        return _buzo;
//    }

//    public void setBuzo(Buzo _buzo) {
//        this._buzo = _buzo;
//    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
    }
    
    public void loadPalabras(){
    	
    	File archivo = new File("palabras.txt");
        palabras = new ArrayList<String>();

        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String word = sc.nextLine();
                palabras.add(word);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    	
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

