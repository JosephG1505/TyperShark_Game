
package typershark_game;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public abstract class Shark extends Thread {
    
    private StackPane _stackpane;
    //posicion del tiburon
    private int x, y;
    //
    private boolean vida;
    //palabra a tipear
    private String _palabra;
    private Label _text;
    
    //Concatena los label - cada letra es un label
    private HBox _concatLabel;
    //imagen a mostrar
    private ImageView imageView;
    private Image tiburon;
    //visible para mostrar en pantalla
    private boolean visible;
    //velocidad dependiendo del nivel
    private int velocidad;

    public Shark(int x, int y, String _palabra, int velocidad) {
        this.x = x;
        this.y = y;
        this.vida = true;
        this._palabra = _palabra;
        this.velocidad = velocidad;
        
        //load and displays image
        this.tiburon = new Image("tiburon.gif");
        this.imageView = new ImageView();
        this.imageView.setImage(tiburon);
        
        //set the image in Pane
        this._stackpane = new StackPane();
        this._stackpane.getChildren().addAll(imageView);
        
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public StackPane getPane() {
        return _stackpane;
    }

    public void setPane(StackPane _stackpane) {
        this._stackpane = _stackpane;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPalabra() {
        return _palabra;
    }

    public void setPalabra(String _palabra) {
        this._palabra = _palabra;
    }

    public Label getText() {
        return _text;
    }

    public void setText(Label _text) {
        this._text = _text;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getTiburon() {
        return tiburon;
    }

    public void setTiburon(Image tiburon) {
        this.tiburon = tiburon;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void mover(){
       x -= velocidad;
        if (x == 0){
            visible = false;
            Buzo.getTiburones().remove(this);
            Buzo.setAlive(false);
        } 
    }
    
    //antes debemos crear un metodo para cargar palabras de un archivo
    public void setLabel(String palabra){
        _concatLabel = new HBox();
        for (int i = 0; i < palabra.length(); i++) {
            Label l = new Label(Character.toString(palabra.charAt(i)));
            _concatLabel.getChildren().addAll(l);
        }
        
    }
    //*******
    //considerar setLabelintoPaane y validar palabra para eliminar un pez
    public void setLabelintoPane(String p){
        _stackpane.getChildren().remove(_concatLabel);
        setLabel(p);
        _stackpane.getChildren().addAll(_concatLabel);
    
    }
    
    
    
    public Boolean validarPalabra(String palabra){
        //int longt = palabra.length();
        if(((Label) this._concatLabel.getChildren().get(0)).getText().equals(palabra) ) {
            return true;
        }
        velocidad = velocidad +1;
        return false;
    }
    //*********
    
    //pintar cada letra que voy acertando
    public void pintar(String a){
        for(Node letra: _concatLabel.getChildren()){
            Label _l = (Label) letra;
            if (a.equals(_l.getText())){
                letra.setStyle("-fx-text-fill: red;-fx-font: bold 17 serif");
                /*
                if (!(_l.getStyle().equals("-fx-text-fill: red;-fx-font: bold 17 serif"))){
                    letra.setStyle("-fx-text-fill: red;-fx-font: bold 17 serif");
                }
                */
            }
        }
    }
    
    protected abstract double getLimite();
    
    @Override
    public void run(){
        
        while(vida){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    
                    _stackpane.setTranslateX(_stackpane.getTranslateX()-3);
                    if(_stackpane.translateXProperty().lessThan(getLimite()).getValue()){
                        vida = false;
                        //cruzo = true;
                        _stackpane.setOpacity(0.0);
                        //Oceano.actualizarOceano();
                    }
                    
                }
            });
            
            try {
                Shark.sleep((int) velocidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Shark.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    }
    
    
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
}
