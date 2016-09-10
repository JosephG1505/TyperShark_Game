
package typershark_game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.util.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Shark extends Pez {
    
    private int n ;
    private int n1;
    private String word;
    private int velocidad;
    
    private File _filePalabras;
    private File _fileCar;
    private LinkedList<String>palabras;
    private LinkedList<String>caracteres;
    
    TranslateTransition _tt;
    
    public Shark(){
        
        n =(int)(Math.random()*4+1); 
        
        this._pane=new Pane();
   
        Image image = new Image("tiburon.gif");
        im = new ImageView();
        im.setImage(image);
        im.setFitWidth(300);
        im.setPreserveRatio(true);
        im.setLayoutX(750);
        im.setLayoutY(fila());
         
        Image image2 = new Image("color.png");
        im2 = new ImageView();
        im2.setImage(image2);
        im2.setFitWidth(600);
        im2.setFitHeight(40);
        im2.setPreserveRatio(true);
        im2.setLayoutX(800);
        im2.setLayoutY(fila()+200);

        CargarPalabras ();
        
        _palabra = new Label(conseguirPalabraAleatoria()); 
        _palabra.setLayoutX(815);
        _palabra.setLayoutY(fila()+200);
        _palabra.setTextFill(Color.WHITE);
        //_palabra.setFont(Font.font("Comic San MS", 20));

        mover(im);
    }
    
    public Shark(String word, String word2, int velocidad){
        
        n =(int)(Math.random()*4+1); 
        
        this.word = word;
        this.velocidad = velocidad;
        this._id=3;
        this.vida=true;
        this.cruzo=true;
        this._pane=new Pane();

        Image image = new Image("tiburon.gif");
        im = new ImageView();
        im.setImage(image);
        im.setFitWidth(300);
        im.setPreserveRatio(true); 
        im.setLayoutX(750);
        im.setLayoutY(fila());

        Image image2 = new Image("color.png");
        im2 = new ImageView();
        im2.setImage(image2);
        im2.setFitWidth(600);
        im2.setFitHeight(40);
        im2.setPreserveRatio(true); 
        im2.setLayoutX(800);
        im2.setLayoutY(200+fila());

        _palabra = new Label(word); 
        _palabra.setLayoutX(815);
        _palabra.setLayoutY(200+fila());
        _palabra.setTextFill(Color.WHITE);
        //_palabra.setFont(Font.font("Comic San MS", 20));

        _palabra2 = new Label(word2); 
        _palabra2.setLayoutX(815);
        _palabra2.setLayoutY(fila()+200);
        _palabra2.setTextFill(Color.WHITE);
        //_palabra2.setFont(Font.font("Comic San MS", 20));

         mover(im);
   
    }
    
    public Shark(String word, int velocidad){
        
        n =(int)(Math.random()*4+1);
        
        this.word = word;
        this.velocidad = velocidad;
        this._id=3;
        this.cruzo=true;
        this._pane=new Pane();
             
        Image image = new Image("tiburon.gif");
        im = new ImageView();
        im.setImage(image);
        im.setFitWidth(300);
        im.setPreserveRatio(true);
        im.setLayoutX(750);
        im.setLayoutY(fila());
         
        Image image2 = new Image("color.png");
        im2 = new ImageView();
        im2.setImage(image2);
        im2.setFitWidth(600);
        im2.setFitHeight(40);
        im2.setPreserveRatio(true);
        im2.setLayoutX(800);
        im2.setLayoutY(fila()+200);
          
        _palabra = new Label(word); 
        _palabra.setLayoutX(815);
        _palabra.setLayoutY(fila()+200);
        _palabra.setTextFill(Color.WHITE);
        //_palabra.setFont(Font.font("Comic San MS", 20));

         mover(im);
    
    }
    
    //Override Methods
    @Override
    public void kill() {
        Shark.this.im.setVisible(false);
        Shark.this._palabra.setVisible(false);
        Shark.this.im2.setVisible(false);
        Shark.this._palabra2.setVisible(false);
        _tt.stop();
        cruzo=false;
    }

    @Override
    public void mover(ImageView im) {
        this._pane.getChildren().addAll(im,Shark.this.im2,Shark.this._palabra, Shark.this._palabra2);
        Shark.this._palabra2.setVisible(false);
        _tt = new TranslateTransition(Duration.millis(this.velocidad*1000),this._pane);
        
        switch (fila()) {
            case 0:
                _tt.setByX(-600f);
                _tt.setByY(75f);
                _tt.setByZ(200f);
                _tt.setCycleCount(1);
                // tt.setAutoReverse(true);    
                break;
            case 125:
                _tt = new TranslateTransition(Duration.millis(this.velocidad*1000), this._pane);
                
                _tt.setByX(-600f); 
                _tt.setByZ(200f);
                _tt.setCycleCount(1);
                //tt.setAutoReverse(true);
                break;
            case 250:
                _tt = new TranslateTransition(Duration.millis(this.velocidad*1000), this._pane);
                
                _tt.setByX(-600f); 
                _tt.setByY(-100f);
                _tt.setByZ(200f);
                _tt.setCycleCount(1);
                //tt.setAutoReverse(true);
                break;
            case 500:
                _tt = new TranslateTransition(Duration.millis(this.velocidad*1000), this._pane);
                
                _tt.setByX(-600f);
                _tt.setByY(-300f);
                _tt.setByZ(200f);
                _tt.setCycleCount(1);
                //tt.setAutoReverse(true); //ayuda que regrese 
                break;
            default:
                break;
        }
        _tt.setOnFinished((ActionEvent event) -> {
            Shark.this.kill();
            //Juego.vidas--;
            //Juego.actualizarValores();
            //Juego.flagMurio=true;
        });
        _tt.play();  
    }

    @Override
    public int fila() {
        switch (n) {
            case 1:
                n1=0;
                break;
            case 2:
                n1=125;
                break;
            case 3:
                n1=250;  
                break;
            case 4:
                n1=500;
                break;
            default:
                break;
        }    
       return n1;
    }
    
    @Override
    public ImageView getImageView() {
        return im;
    }
    
    @Override
    public void setImageView(ImageView im) {
        this.im = im;
    }
    
    @Override
    public ImageView getIm2() {
        return im2;
    }

    @Override
    public Label getWord() {
        return _palabra;
    } 
    
    public void setWord(Label palabra) {
        this._palabra = palabra;
    }
    
    @Override
    public Label getWord2() {
        return _palabra2;
    }
    
    //Methods
    public void CargarPalabras(){
        
        Scanner sc = null;
        this._filePalabras = new File ("Palabras.txt");
        this._fileCar = new File("Caracteres.txt");
        this.caracteres = new LinkedList<>();
        this.palabras = new LinkedList<>();
        try {
            sc = new Scanner(new FileReader(this._fileCar));
            while (sc.hasNext()) {
         
                this.caracteres.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error Al Abrir Archivo De Caracteres");
        }
        sc.close();
        
        try {
            sc = new Scanner(new FileReader(this._filePalabras));
            while (sc.hasNext()) {
                ///reviewScore = Archi.nextInt();
                this.palabras.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error Al Abrir Archivo De Palabras");
        }
        sc.close();
    }
    
    public String conseguirPalabraAleatoria(){
        
        int valorRandom=(int)(Math.random()*this.palabras.size());
        return this.palabras.get(valorRandom);
    }
    
    public String conseguirCaracterAleatoria(){
        int valorRandom=(int)(Math.random()*this.caracteres.size());
        return this.caracteres.get(valorRandom);
    }
    

    
}

//scratch





/********Nuevo*********/
    /*
    private ImageView imagen;
    private Label label;
    private Label text;
    private Pane _pane;
    
    private int x, y;
    private String word;
    private boolean visible;
    String s;
    private int speed;


    public Tiburon(int x, int y, String word, int speed) throws IOException {
        
        this._pane = new Pane();
        InputStream img = Files.newInputStream(Paths.get("src/typershark/proyect/imagenes/Tiburon.png"));
        Image imgTiburon = new Image(img);
        img.close();

        this.imagen = new ImageView(imgTiburon);
        this.imagen.setFitHeight(600);
        this.imagen.setFitHeight(600);

        _pane.getChildren().addAll(imagen);

        this.visible=true;
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.word=word;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getWord() {
        return word;
    }
    
    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void move() {
        x -= speed;
        if (x == 0){
            visible = false;
          Buzo.getTiburon().remove(this);
          Buzo.die(false);
        }
    }
    
    */